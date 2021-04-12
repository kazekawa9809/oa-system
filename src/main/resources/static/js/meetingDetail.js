var partList = new Array();
partList.push({meetingId: "1", creatorId: "2", participantId: "1"});
partList.push({id: "1", goodsName: "2", supplier: "4"});

$.ajax({
    //访问后台的路径
    url: "/meeting/addDetail",
    //将数据通过函数转换
    data: JSON.stringify(partList),
    dataType:"json",//指定数据类型为JSON
    //指定类型，不然会报错，无法解析提交类型
    contentType: "application/json;charset=utf-8",
    type: 'post',//指定提交方式为post
    success: function(data) {
        alert("添加成功！");
    }
});