/*将一般的JSON格式转为EasyUI TreeGrid树控件的JSON格式
 * @param rows:json数据对象
 * @param idFieldName:表id的字段名
 * @param pidFieldName:表父级id的字段名
 * @param fileds:要显示的字段,多个字段用逗号分隔 
 */
function ConvertToTreeGridJson(rows, idFieldName, pidFieldName, fileds) {
	function exists(rows, ParentId) {
		for (var i = 0; i < rows.length; i++) {
			if (rows[i][idFieldName] == ParentId)
				return true;
		}
		return false;
	}
	var nodes = [];
	// get the top level nodes
	for (var i = 0; i < rows.length; i++) {
		var row = rows[i];
		if (!exists(rows, row[pidFieldName])) {
			var data = {
				id : row[idFieldName]
			}
			var arrFiled = fileds.split(",");
			for (var j = 0; j < arrFiled.length; j++) {
				if (arrFiled[j] != idFieldName)
					data[arrFiled[j]] = row[arrFiled[j]];
			}
			nodes.push(data);
		}
	}

	var toDo = [];
	for (var i = 0; i < nodes.length; i++) {
		toDo.push(nodes[i]);
	}
	while (toDo.length) {
		var node = toDo.shift(); // the parent node
		// get the children nodes
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (row[pidFieldName] == node.id) {
				var child = {
					id : row[idFieldName]
				};
				var arrFiled = fileds.split(",");
				for (var j = 0; j < arrFiled.length; j++) {
					if (arrFiled[j] != idFieldName) {
						child[arrFiled[j]] = row[arrFiled[j]];
					}
				}
				if (node.children) {
					node.children.push(child);
				} else {
					node.children = [ child ];
				}
				toDo.push(child);
			}
		}
	}
	return nodes;
};
// 假设这是从后台获取到的json数据
// var dataJsonObj = [{ 'Id': 1, 'ParentId': 0, 'Title': '猫分类', 'CreateTime':
// '2015/06/04 01:05:32' }, { 'Id': 2, 'ParentId': 1, 'Title': '田园猫',
// 'CreateTime': '2015/06/04 01:11:30' }, { 'Id': 3, 'ParentId': 1, 'Title':
// '英国短毛猫', 'CreateTime': '2015/06/04 01:11:51' }, { 'Id': 4, 'ParentId': 1,
// 'Title': '布偶猫', 'CreateTime': '2015/06/04 01:12:05' }];
// 要显示的字段
// var fileds = "Id,Title,CreateTime";
// 获取已转为符合treegrid的json的对象
// var nodes = ConvertToTreeGridJson(dataJsonObj, "Id", "ParentId", fileds);
// JSON.stringify(nodes)
// [{"id":1,"Title":"猫分类","CreateTime":"2015/06/04
// 01:05:32","children":[{"id":2,"Title":"田园猫","CreateTime":"2015/06/04
// 01:11:30"},{"id":3,"Title":"英国短毛猫","CreateTime":"2015/06/04
// 01:11:51"},{"id":4,"Title":"布偶猫","CreateTime":"2015/06/04 01:12:05"}]}]
