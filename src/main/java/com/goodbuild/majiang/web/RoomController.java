package com.goodbuild.majiang.web;

import com.goodbuild.majiang.domain.JoinPlayer;
import com.goodbuild.majiang.domain.PageResult;
import com.goodbuild.majiang.domain.ResultBean;
import com.goodbuild.majiang.domain.Room;
import com.goodbuild.majiang.util.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 15:09
 * @Description: 游戏房间
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/room")
@Api(value = "RoomController", description = "游戏房间")
public class RoomController {

    @GetMapping("/searchRoom/{roomId}")
    @ApiOperation(value = "searchRoom", notes = "根据房间号搜索房间", produces = "application/json")
    @ApiImplicitParam(name = "roomId", value = "房间号", required = true, dataType = "long", example = "1")
    public ResultBean<Room> searchRoom(@PathVariable("roomId") long roomId) {
            Assert.isNotNull(roomId, "roomId 不能为空！");
        Room room = new Room();
        room.setId(roomId);
        return new ResultBean(room);
    }

    @PostMapping("/createRoom")
    @ApiOperation(value = "createRoom", notes = "创建房间", produces = "application/json")
    @ApiImplicitParam(name = "room", value = "房间对象", required = true, dataType = "Room")
    public ResultBean<Long> createRoom(@RequestBody  Room room) {
        Assert.isNotNull(room, "room不能为空！");
        return new ResultBean<>(room.getId());
    }

    @GetMapping("/roomList")
    @ApiOperation(value = "roomList", notes = "房间列表", produces = "application/json")
    public ResultBean<PageResult<Room>> roomList() {
        return new ResultBean<>(new PageResult<>(0, new ArrayList<>()));
    }

    @PostMapping("/joinRoom")
    @ApiOperation(value = "joinRoom", notes = "加入房间", produces = "application/json")
    @ApiImplicitParam(name = "joinPlayer", value = "加入玩家", required = true, dataType = "JoinPlayer")
    public ResultBean<Room> joinRoom(@RequestBody  JoinPlayer joinPlayer) {
        return new ResultBean<>(new Room());
    }

    @PostMapping("/exitRoom")
    @ApiOperation(value = "exitRoom", notes = "退出房间", produces = "application/json")
    @ApiImplicitParam(name = "joinPlayer", value = "加入玩家", required = true, dataType = "JoinPlayer")
    public ResultBean<Room> exitRoom(@RequestBody  JoinPlayer joinPlayer) {
        return new ResultBean<>(new Room());
    }

}
