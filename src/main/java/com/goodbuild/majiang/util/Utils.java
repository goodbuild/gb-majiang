package com.goodbuild.majiang.util;



import com.goodbuild.majiang.config.Config;
import com.goodbuild.majiang.enums.MaJiangCardEnum;
import com.goodbuild.majiang.exception.CanNotChiException;
import com.goodbuild.majiang.exception.CanNotHuException;
import com.goodbuild.majiang.exception.IsGangException;
import com.goodbuild.majiang.exception.IsPengException;
import com.goodbuild.majiang.game.MaJiang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Utils
 * @ProjectName MaJiang
 * @Description:
 * @Author xuelong
 * @Date 2018/9/25下午2:10
 * @Version 1.0.0
 */
public class Utils {
    public static List<MaJiang> initNoWordMaJiang() {
        List<MaJiang> list = new ArrayList<MaJiang>();

        list.addAll(initMaJiangList(MaJiangCardEnum.WangZi)); // 万
        list.addAll(initMaJiangList(MaJiangCardEnum.SuoZi)); // 索 、条
        list.addAll(initMaJiangList(MaJiangCardEnum.TongZi)); // 筒
        // list.addAll(initMaJiangList("w")); // 花
        return list;
    }


    public static List<MaJiang> initZiMaJiang() {
        List<MaJiang> list = new ArrayList<MaJiang>();
        MaJiangCardEnum[] ziList = new MaJiangCardEnum[]{MaJiangCardEnum.Dong, MaJiangCardEnum.Nan, MaJiangCardEnum.Xi, MaJiangCardEnum.Bei,
                MaJiangCardEnum.HongZhong, MaJiangCardEnum.FaCai, MaJiangCardEnum.BaiBan};
        for (MaJiangCardEnum MaJiangCard : ziList) {
            MaJiang maJiang = new MaJiang(MaJiangCard);
            list.add(maJiang);
            list.add(maJiang);
            list.add(maJiang);
            list.add(maJiang);
        }
        return list;
    }

    private static List<MaJiang> initMaJiangList(MaJiangCardEnum MaJiangCard) {
        List<MaJiang> list = new ArrayList<MaJiang>();
        for (int i=1; i<10; i++) {
            MaJiang maJiang = new MaJiang(MaJiangCard, i);
            list.add(maJiang);
            list.add(maJiang);
            list.add(maJiang);
            list.add(maJiang);
        }

        return list;
    }

    /**
     *
     * 找出可以吃的牌 包括 ?BC? 和 A?B
     * @param list
     * @return
     */
    public static List<MaJiang> fingChi(List<MaJiang> list) throws CanNotChiException {
        List<MaJiang> chiList = new ArrayList<>();

        if (list.size() < 2) { // 单张就不算了
            throw new CanNotChiException();
        }

        for (int i = 0; i < list.size() - 1; i++) {
            try {
                chiList.addAll(getChi(list.get(i), list.get(i + 1), null));
            } catch (Exception e) {
                continue;
            }
        }

        if (chiList.size() == 0) {
            throw new CanNotChiException();
        }

        return chiList;
    }

    /**
     * 主要判断前两张牌是否可以吃，
     * @param oneMaJiang
     * @param twoMaJiang
     * @param threeMaJiang
     * @return
     * @throws CanNotChiException
     * @throws IsPengException
     * @throws IsGangException
     */
    public static List<MaJiang> getChi(MaJiang oneMaJiang, MaJiang twoMaJiang, MaJiang threeMaJiang) throws CanNotChiException, IsPengException, IsGangException {
        List<MaJiang> chiList = new ArrayList<>();

        MaJiangCardEnum maJiangCardEnum = oneMaJiang.getMaJiangCardEnum();
        int oneSortId = oneMaJiang.getSortId();
        int twoSortId = twoMaJiang.getSortId();
        int threeSortId = threeMaJiang == null ? 0 : threeMaJiang.getSortId();

        int oneRange = oneSortId - twoSortId;
        int twoRane = twoSortId - threeSortId;

        switch (oneRange) {
            case Config.RANGE_BC:
                int oneNum = oneMaJiang.getNum();
                int twoNum = twoMaJiang.getNum();
                if (oneNum != 1) { // 头不取 1
                    chiList.add(new MaJiang(maJiangCardEnum, oneNum - 1));
                }
                if (twoNum != 9) { // 尾不取9
                    chiList.add(new MaJiang(maJiangCardEnum, twoNum + 1));
                }
                break;
            case Config.RANGE_AC:
                chiList.add(new MaJiang(maJiangCardEnum, oneMaJiang.getNum() + 1));
                break;
            case Config.RANGE_PENG:
                if (twoRane == Config.RANGE_GANG) {
                    throw new IsGangException();
                } else {
                    throw new IsPengException();
                }
            default:
                throw new CanNotChiException();

        }

        return chiList;
    }

    public static List<MaJiang> findHu(List<MaJiang> list) throws CanNotHuException {
        // 单张
        int num = list.size();
        if (num == 1) {
            return list;
        }

        List<MaJiang> huList = new ArrayList<>();
        int pengNum = 0;
        int checkout = 0;
        for (int i = 0; i < list.size()-1;) {
            MaJiang one = list.get(i);
            MaJiang two = list.get(i+1);
            MaJiang three = null;

            try{
                three = list.get(i+2);
            } catch (Exception e) {
            }

            try {
                if (one.getSortId() - three.getSortId() != Config.RANGE_AC) {// 本身不是ABC,但这里有个bug 就是 23456 这种糊147 会变成 47
                    huList.addAll(getChi(one, two, three));
                    checkout++;
                    i = i +2;
                } else {
                    i = i + 3;
                }
            } catch (CanNotChiException e) {
                huList.add(one);
                i++;
            } catch (IsPengException e) {
                pengNum++;
                huList.add(one);
                i = i +2;
            } catch (IsGangException e) {
                i = i + 3;
            }

            if (checkout > 3 || pengNum > 2) {
                throw new CanNotHuException();
            }
        }

        return huList;
    }
}
