<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2020-03-28
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品信息</title>
    <%--<jsp:include page="../../../plugins/business-core/static/headers/base.jsp"></jsp:include>--%>
    <jsp:include page="../../../plugins/business-core/static/headers/base.jsp"></jsp:include>

    <script src="../static/js/resource.js"></script>
    <script src="../static/js/wangEditor.min.js"></script>
    <script src="../static/js/wangEditor-fullscreen-plugin.js"></script>
    <link rel="stylesheet" href="../static/css/wangEditor.min.css">
    <link rel="stylesheet" href="../static/css/wangEditor-fullscreen-plugin.css">

</head>
<body id="web1">
<mk-top-bottom height="100%" top-height="auto">
    <mk-search-panel slot="top">

        <mk-search-visible>
            <!--商品名称-->
            <su-form-group :label-name="formFields.goods_name.label" class="form-control-row" col="4" label-width="100px" label-align="right">
                <su-textbox :data.sync="params.goods_name"></su-textbox>
            </su-form-group>
            <!--商品编号-->
            <su-form-group :label-name="formFields.goods_code.label" class="form-control-row" col="4" label-width="100px" label-align="right">
                <su-textbox :data.sync="params.goods_code"></su-textbox>
            </su-form-group>
            <!--商品类别-->
            <su-form-group :label-name="formFields.type_code.label" class="form-control-row" col="4" label-width="100px" label-align="right">
                <su-select type="text" :select-value.sync="params.type_code"  value-name="type_code" label-name="type_code"
                        url="/demo/goodsController/selectGoodsSortAll" ></su-select>
            </su-form-group>
            </su-form-group>

        </mk-search-visible>
        <mk-search-hidden>

        </mk-search-hidden>


        <div slot="buttons" class="pull-right" style="text-align: right;">
            <su-button s-type="primary" @click="search">查询</su-button>
            <su-button s-type="default" @click="reset">重置</su-button>
        </div>
    </mk-search-panel>

    <mk-panel title="" height="100%" line="true" slot="bottom" lass="pull-right" style="text-align: right" v-cloak>
        <su-button class="btn-operator" s-type="default" labeled="true" label-ico="plus" v-on:click="add">新增</su-button>
        <su-button class="btn-operator" s-type="default" labeled="true" label-ico="edit" v-on:click="edit">编辑</su-button>
        <su-button class="btn-operator" s-type="default" labeled="true" label-ico="trash-o" v-on:click="del">删除</su-button>
        </div>
        <choose-org v-ref:choseid combobox=false combotree=false :selectorgid="selectorgid"
                    :type="orgtype" :options="" :is-data-authz="isDataAuthz"
                    :is-keyword="isKeyword"></choose-org>
        <div class="row" style="height:100%">
            <table id="goodsInfoList" >
            </table>
        </div>
    </mk-panel>
</mk-top-bottom>
<script type="text/javascript" async>
    var infoVue = new Vue({
        el: "#web1",
        data:{
            oldEditRow:'',
            newEditRow:'',
            formFields:{},
            params:{
                goods_name:'',
                goods_code:'',
                type_code:''
            },
            goods_code:[],

        },
        ready:function (newEditRow,oldEditRow) {
            oldEditRow = null,
            newEditRow = null,
            this.initInfoTable(oldEditRow, newEditRow);
        },
        methods:{
            initInfoTable:function (oldEditRow, newEditRow) {
                var me = this;
                ComponentUtil.getFormFields("demo_wy",me);
                var basePath = "${Config.baseURL}";
                $("#goodsInfoList").datagrid({
                    title: '',
                    url: basePath + 'goodsController/selectGoodsInfo',
                    height: "100%",
                    queryParams: me.params,
                    width: "100%",
                    method: 'post',
                    rownumbers: true,
                    pagination: true,
                    pagePosition: 'bottom',  //分页显示在下边
                    ctrlSelect: true,
                    fitColumns: true,
                    pageNumber: 1,
                    pageSize: 6,
                    pageList: [3, 4, 5, 6],
                    columns: [[
                        {checkbox:true,field: 'id',title: 'id', width: 100},
                        {field: 'type_code', title: '所属类别', width: 100},
                        {field: 'goods_name', title: '商品名称', width: 100},
                        {field: 'goods_code', title: '商品编号', width: 100},
                        {field: 'num', title: '商品数量', width: 100,editor:'text'},
                        {   field: 'imgname', title: '图片名称', width: 100,
                        formatter:function (value,row,index) {
                            return "<a href=\"javascript:void(0);\" onclick=\"infoVue.down(\'"+ row.imgId +"\')\">"+value+"</a>"
                        }},
                        {field:'unit',title:'计量单位',width:100,
                            editor: {
                                type: 'combobox',
                                options: {
                                    url: "${Config.baseURL}globalCache/queryCodeByKey/pcode/market/unitType_wy",
                                    valueField: "value",
                                    textField: "name",
                                    required: true
                                }
                            }
                        }

                        // {field:'create_user',title:'创建人',width:100},
                        // {field:'create_time',title:'创建时间',width:100} ,
                        // {field:'update_user',title:'更新人',width:100},
                        // {field:'update_time',title:'更新时间',width:100}
                    ]],
                    onClickCell: function (rowIndex, field, value) {
                        if (oldEditRow == null) {
                            $("#goodsInfoList").datagrid('beginEdit', rowIndex);
                            var ed = $("#goodsInfoList").datagrid('getEditor', {index: rowIndex, field: "num"});
                            console.log("ed的值为:::"+ed);
                            $(ed.target).focus();
                            console.log("ed.target的值为::"+ed.target);

                            $(ed.target).keypress(function (e) {//点击表格与回车结合
                                if (e.which == 13) {
                                    newEditRow = rowIndex + 1;
                                    var row = $("#goodsInfoList").datagrid("getSelected");

                                    console.log(row.num)
                                   // me.editNum();
                                   //  debugger
                                    var rowsData = $("#goodsInfoList").datagrid('getRows');
                                    if (newEditRow == rowsData.length) {
                                        return;
                                    }
                                    $("#goodsInfoList").datagrid('endEdit', rowIndex);
                                }
                            });
                            oldEditRow = rowIndex;
                        } else if (rowIndex != oldEditRow) {
                            $("#goodsInfoList").datagrid('endEdit', oldEditRow);
                        }
                    },
                    onAfterEdit: function (rowIndex, rowData, changes) {//结束编辑后，进入下一行
                        console.log("after", rowIndex)
                        $("#goodsInfoList").datagrid('beginEdit',newEditRow);
                        var editCell = $("#goodsInfoList").datagrid('getEditor', {index: newEditRow, field: "num"});
                        $(editCell.target).focus();
                        oldEditRow = newEditRow;
                        $(editCell.target).keypress(function (e) {//回车连续使用
                            if (e.which == 13) {
                                newEditRow = oldEditRow + 1;
                                var rowsData = $("#goodsInfoList").datagrid('getRows');
                                if (newEditRow == rowsData.length) {
                                    return;
                                }
                                $("#goodsInfoList").datagrid('endEdit', oldEditRow);
                            }
                        });
                    }

                    // ComponentUtil.buildGrid("demo_wy",$("#goodsInfoList"),{
                    //     url : basePath+'goodsController/selectGoodsInfo',
                    //     method:'post',
                    //     height:"100%",
                    //     fitColumns:true,
                    //     rownumbers:true,
                    //     singleSelect:true,
                    //     pagination : true,
                    //     queryParams:me.params,
                    //     fit:true,
                    //     rowStyler:function(idx,row){
                    //         return "height:35px;font-size:12px;";
                    //     },
                    // onClickCell:function(rowIndex, field, value){
                    //     if (field == "goods_code"){
                    //         var rows = $("#goodsInfoList").datagrid('getRows');
                    //         var row = rows[rowIndex];
                    //         MainFrameUtil.openDialog({
                    //             id:"弹出框id",//弹出框的id, 后边工具中方法的id都是对应此值
                    //             params:{},//传递参数.可以通过 MainFrameUtil.getParams() 获取
                    //             htmlCodes:"<div class='row'>999asadf<div>",// html 代码片段
                    //             iframe:true,//是否使用iframe加载
                    //             href:'dialog',// html 片段 rul
                    //             title:'弹出框',
                    //             modal:true,
                    //             width:600,
                    //             height:500,
                    //             callback:function(htmlObj){//渲染完成回调函数
                    //
                    //                 alert(htmlObj);
                    //
                    //             },
                    //             onClose:function(params){//点击关闭回调函数
                    //
                    //             }
                    //         });
                    //     }
                    // }
                });
            },
            down:function(img_id){
              var path = "${Config.getConfig('file.service.url')}" + img_id;
              $.downloadFile(path);
            },
            downImg:function(value,rows,index){
                // debugger
                //下载
                return "<a href=\"${Config.getConfig('file.service.url')}"+value+"\">"+value+"</a>";
                <%--return '<a href="${Config.getConfig(\'file.service.url\')}"+value>'+value+'</a>'--%>
            },
            reset:function () {
                this.params = {
                    goods_code:'',
                    goods_name:'',
                    type_code:''
                }
            },
            search: function () {
                $("#goodsInfoList").datagrid('reload');
            },
            add: function () {
                MainFrameUtil.openDialog({
                    id:"infoAdd",
                    href:basePath+'view/fweb-demo/page/goodsInfo-add',
                    iframe:true,
                    modal:true,
                    width:1000,
                    height:500,
                    onClose:function (param) {
                        $("#goodsInfoList").datagrid('reload');
                    }
                })
            },
            editNum:function(){
                var row = $(me).datagrid("getSelected");
                console.log(JSON.stringify(row));
                if (row == null){
                    console.log("row 为 null")
                } else {
                    $.ajax({
                        type:"post",
                        url:basePath+"goodsController/updateGoodsInfoNum",
                        // contentType: 'application/json;;charset=UTF-8',
                        data:{id:row.id,num:row.num},
                        dataType:"json",
                        success:function(data){
                            if (data.flag==null) {
                                alert("修改失败")
                            }else{
                                //alert("修改成功")

                            }

                        }
                    });
                }
            },
            edit: function () {  // 修改信息
                var row = $('#goodsInfoList').datagrid('getSelected');
                if (row == null){  //如果未选中数据
                    MainFrameUtil.alert({
                        title: "警告",
                        body: "请先选择一行数据！",
                        onClose: function (type) {
                            //回调事件
                        }
                    });
                }else {
                    MainFrameUtil.openDialog({
                        id: "infoEdit",
                        href: basePath + 'view//fweb-demo/page/goodsInfo-edit',
                        params: row,
                        iframe: true,
                        modal: true,
                        width: 1000,
                        height: 500,
                        onClose: function (params) {//点击关闭回调函数
                            alert(params.flag);//新增页面传递的参数
                            $("#goodsInfoList").datagrid('reload');
                        },
                    });
                }
            },
            del:function () {
                var rows = $('#goodsInfoList').datagrid('getChecked');
                if (rows.length < 1){  //如果未选中数据
                    MainFrameUtil.alert({
                        title: "警告",
                        body: "请先选中一行数据！",
                        onClose: function (type) {

                        }
                    });
                }else {
                    MainFrameUtil.confirm({
                        title: "您确认要删除吗?", body: "删除后不能恢复",
                        onClose: function (type) {
                            if (type == "ok") {//确定
                                var infoId = new Array();
                                for (var i in rows){
                                    infoId[i] = rows[i].id;
                                }
                                $.ajax({
                                    url: basePath + "goodsController/deleteGoodInfo",
                                    type: 'post',
                                    dataType: 'json',
                                    data:{
                                        id:infoId.join(",")
                                    },
                                    error: function () {
                                        alert('error');
                                    },
                                    success: function (data) {
                                        if (data.flag == 0) {
                                            alert("删除失败")
                                        } else {
                                            alert("删除成功");
                                            $("#goodsInfoList").datagrid('reload');
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    })
</script>
</body>

</html>
