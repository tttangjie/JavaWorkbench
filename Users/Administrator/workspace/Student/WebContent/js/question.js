
var questionAddEditor ;
 var a=[];
 
//填空题，空格计数器
var TOTAL_BLANKS = 0;

// var xuan_init;
$(function(){
	//alert("111");
	 var _ele = $("#xuanze");
    _ele.after("<span style='margin-left:10px;'></span>");
    
    questionAddEditor = KindEditor.create("#QuestionAddForm [name=content]", TT.kingEditorParams);
    
    xuan_init(2);
    
    
  //捕获题型选择事件
	if(document.getElementById("qtype")){
		$("#qtype").combobox({
			onChange: function () {
				var qtype = $("#qtype").combobox("getValue");
				//清空当前的选项
				$("#key_setting").empty();
				$("#btn_xuan_addrow").hide();	
				TOTAL_BLANKS = 0;
				//选择题
				if(2==qtype || 3==qtype){
					xuan_init(qtype);
				}else if(1==qtype){
					tiankong();
				}
			}
		});
	}
});
//提交表单
function submitFunctionForm(){
	//有效性验证
	if(!$('FunctionAddForm').form('validate')){
		$.messager.alert('提示','表单还未填写完成!');
		return ;
	}	
}

function xuan_init(qtype){
	$("#btn_xuan_addrow").show();
//	var a=[];
	var options = ['A','B','C','D'];
	$("#key_setting").append('<table class="stable" width="500" align="left" id="key_setting_table">');
	$(options).each(function(i){
		var html = '<tr>';
		html += '<td>选项' + this + '</td>';
		if(2==qtype){
			html += '<td><input type="radio" class="validate[required]" name="skey" value="'+this+'" /></td>';
		}else if(3==qtype){
			html += '<td><input type="checkbox" class="validate[required,minCheckbox[4]]" name="skey" value="'+this+'" /></td>';
		}
		//alert(this);
		var aremove = '<a href="javascript:;" onclick="$(this).parent().parent().remove()">移除</a>';
		html += '<td><textarea  name="soption" style="width:100px;height:50px;visibility:hidden;" id="toption_' + this + '"></textarea> '+aremove+'</td>';
		
		html += '</tr>';
		
		$("#key_setting_table").append(html);
		a[i] = KindEditor.create("#key_setting_table[id=toption_"+this+"]", TT.kingEditorParams);
	}); 
	$("#key_setting").append('</table>');

}


function xuan_addrow (qtype){
	$("#btn_xuan_addrow").show();
	var options = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	for(var i=0;i<options.length;i=i+1){
		var this_value = options[i];
		if(!document.getElementById("toption_"+this_value)){
			var html = '<tr>';
			html += '<td>选项' + this_value + '</td>';
			if(2==qtype){
				html += '<td><input type="radio" class="validate[required]" name="skey" value="'+this_value+'" /></td>';
			}else if(3==qtype){
				html += '<td><input type="checkbox" class="validate[required,minCheckbox[4]]" name="skey" value="'+this_value+'" /></td>';
			}
			var aremove = '<a href="javascript:;" onclick="$(this).parent().parent().remove()">移除</a>';
			html += '<td><textarea  name="soption" style="width:100px;height:50px;visibility:hidden;" id="toption_' + this_value + '"></textarea> '+aremove+'</td>';
			html += '</tr>';
			$("#key_setting_table").append(html);
			a[i] = KindEditor.create("#key_setting_table[id=toption_"+this_value+"]", TT.kingEditorParams);
			break;
		}
	};
}

function clearFunctionForm(){
	$('#FunctionAddForm').form('reset');
}

function getCheckedval()
{
	var checkedval=[];
	if($('#qtype').combobox('getValue')==2)
	{
	   var val = $('#key_setting_table input[name="skey"]:checked ').val();
	   checkedval.push(val);
	}else if($('#qtype').combobox('getValue')==3)
	{
		$('#key_setting_table input[name="skey"]:checked').each(function(){
				var val=$(this).val()
				checkedval.push(val);
		});
	}
	checkedval=checkedval.join(",");
	
	return checkedval;
}


function submitquestionForm()
{
	var result=[];
	
	var checkedval=getCheckedval();
	//alert(checkedval);
	
	var length=$('#key_setting_table input[name="skey"]').length;
	var cid=$('#cid').val();
	//获取题目类型
	var qtype=$('#qtype').combobox('getText');
	//残疾种类
	var cate=$('#cate').combobox('getText');
	 for(var i=0;i<length;i++)
    {
	  var skey=$('#key_setting_table input[name="skey"]').eq(i).val();
	   a[i].sync();
	  var soption=$('#key_setting_table textarea[name="soption"]').eq(i).val();
	  result[i]={"skey":skey,"soption":soption};
    }
	   questionAddEditor.sync();
	   var maincontent=$('#ds').val();
	 $.post("Questioncontroller/addQustion.do",{maincontent:maincontent,result:result,length:length,questioncategory:qtype,deformity_category:cate,knowledge_id:cid,answer:checkedval}, function(data){
		if(data.status == 200){
			$.messager.alert('提示','新增题目成功!');
		}
	  });   
		
	
} 

function tiankong(){
	var html = '<table class="stable" width="500" align="left">';
	html += '<tr>';
	html += '<td id="TD_BLANKS"></td>';
	html += '</tr>';
	
	html += '<tr>';
	html += '<td><input type="button" class="btn" value="增加填空" onclick="add_Blank();" /> <input type="checkbox" value="yes" name="qcomplex" />混杂模式批改</td>';
	html += '</tr>';
	html += '</table>';
	$("#key_setting").html(html);
}



function showKnowledge()
{
    var _ele = $("#xuanze");
	//_ele.after("<span style='margin-left:10px;'></span>");
	$("<div>").css({padding:"5px"}).html("<ul>")
	.window({
		width:'500',
	    height:"450",
	    modal:true,
	    closed:true,
	    iconCls:'icon-save',
	    title:'选择知识点',
	    onOpen : function(){
	    	var _win = this;
	    	$("ul",_win).tree({
	    		url:'knowledgepointcontroller/selectknowledgepoint.do',
	    		animate:true,
	    		onClick : function(node){
	    			if($(this).tree("isLeaf",node.target)){
	    				// 填写到cid中
	    				$("#cid").val(node.id);
	    				_ele.next().text(node.text).attr("cid",node.id);
	    				$(_win).window('close');
	    			}
	    		}
	    	});
	    },
	    onClose : function(){
	    	$(this).window("destroy");
	    }
	}).window('open');
} 


/********** 工具函数 ***********/

 function add_Blank(){
	if(TOTAL_BLANKS>7) {
		alert("填空数不能大于8个");
		return;
	}
	
	TOTAL_BLANKS++;
	//var ClientID = "content";
	//var content = "" + FCKeditorAPI.GetInstance(ClientID).GetXHTML(true);
	//var content=questionAddEditor.;
	  questionAddEditor.sync();
	  var content=$('#ds').val();
	  alert(content);
	//判断是否存在即将要插入的BLANK
	var index_of_new_blank = content.indexOf("[BlankArea"+TOTAL_BLANKS+"]");
	while(index_of_new_blank>-1){
		TOTAL_BLANKS++;
		index_of_new_blank = content.indexOf("[BlankArea"+TOTAL_BLANKS+"]");
	}
	
	$("#TD_BLANKS").append('<span>'+TOTAL_BLANKS+'：<input name="skey'+TOTAL_BLANKS+'" type="input" maxlength="30" class="txt" /><a href="javascript:;" mid="'+TOTAL_BLANKS+'">r</a></span></br>');
	//FCKeditorAPI.GetInstance(ClientID).InsertHtml("[BlankArea"+TOTAL_BLANKS+"]");
	var content=content+"[ BlankArea"+TOTAL_BLANKS+" ]";
	questionAddEditor.html(content);
	// questionAddEditor.sync();
	
	$("#TD_BLANKS span a").click(function(){
		content = "" + FCKeditorAPI.GetInstance(ClientID).GetXHTML(true);
		$(this).parent().remove();
		var mid = $(this).attr("mid");
		content = content.replace("[BlankArea"+mid+"]","");
		FCKeditorAPI.GetInstance(ClientID).SetHTML(content);
	});
	
}
 
