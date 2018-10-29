//定义一个avalonjs的控制器
var viewmodel = avalon.define({
    //id必须和页面上定义的controller名字相同，否则无法控制页面
    $id: "viewmodel",
    datalist: {},
    text: "请求数据",
    request: function () {
        $.ajax({
            type: "get",
            url: "/hanlp1/getone",    //向后端请求数据的url
            success: function (data) {
                viewmodel.datalist = data;
            }
        });
    }
});
