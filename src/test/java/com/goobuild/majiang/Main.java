package com.goobuild.majiang;



import com.goodbuild.majiang.PlayFactory;
import com.goodbuild.majiang.config.Config;
import com.goodbuild.majiang.domain.User;
import com.goodbuild.majiang.game.GamePlayer;
import com.goodbuild.majiang.game.MaJiang;
import com.goodbuild.majiang.game.Play;
import com.goodbuild.majiang.util.Utils;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Main
 * @ProjectName MaJiang
 * @Description:
 * @Author xuelong
 * @Date 2018/9/25下午1:08
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) throws Exception {
        palyTest();
    }

    public static void palyTest() throws Exception{
        Play play = testBasePlay();
        User curr = (User) play.getCurrPlayer();
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("请 %s 出牌: ", curr.getUsername()));
        String outText = scanner.nextLine();
        boolean go = true;
        while (go) {
            curr = (User) play.getCurrPlayer();
            MaJiang maJiang = new MaJiang(outText);
            switch (outText) {
                case "peng":
                    play.peng( null, maJiang);
                    break;
                case "gang":
                    play.gang(null, maJiang);
                    break;
                case "chi":
                    play.chi(null, maJiang);
                    break;
                case "hu":
                    play.hu(curr, maJiang);
                    go = false;
                    break;
                case "zimo":
                    play.zimo(curr, maJiang);
                    go = false;
                    break;
                default:
                    play.out(curr, maJiang);
                    play.in();

            }

            System.out.println();
            System.out.println(String.format("请 %s 出牌: ", curr.getUsername()));
            outText = scanner.nextLine();
        }


    }

    public static Play testBasePlay() throws Exception{
       /* GamePlayer g1 = new GamePlayer(1, 100);
        GamePlayer g2 = new GamePlayer(2, 100);
        GamePlayer g3 = new GamePlayer(3, 100);
        GamePlayer g4 = new GamePlayer(4, 100);*/
        User user1 = new User(1L, 100, "张三");
        User user2 = new User(2L, 100, "李四");
        User user3 = new User(3L, 100,"王五");
        User user4 = new User(4L, 100, "赵六");

        Play play = PlayFactory.createBasePlay(Config.MAX_GAMG_NUM_8);

        play.addGamePlayer(user1);
        play.addGamePlayer(user2);
        play.addGamePlayer(user3);
        play.addGamePlayer(user4);

        play.faPai();

        play.toString();

        return play;
    }


    @Test
    public static void testHu() throws Exception {
        List<MaJiang> maJiangs = new ArrayList<>();
        maJiangs.add(new MaJiang("w6"));
        maJiangs.add(new MaJiang("w6"));
        maJiangs.add(new MaJiang("w7"));
        maJiangs.add(new MaJiang("w8"));

        maJiangs.add(new MaJiang("w6"));
        maJiangs.add(new MaJiang("t7"));
        maJiangs.add(new MaJiang("t7"));
        maJiangs.add(new MaJiang("t7"));

        maJiangs.add(new MaJiang("s2"));
        maJiangs.add(new MaJiang("s3"));
        maJiangs.add(new MaJiang("s4"));
        maJiangs.add(new MaJiang("bf"));

        maJiangs.add(new MaJiang("bf"));

        maJiangs.sort(new Comparator<MaJiang>() {
            public int compare(MaJiang n1, MaJiang n2) {
                return n1.getSortId() - n2.getSortId();
            }
        });

        // TODO 删除日志
        System.out.println();
        System.out.println("测试胡牌结果");
        System.out.println(maJiangs);
        System.out.println(Utils.findHu(maJiangs));
    }

}
