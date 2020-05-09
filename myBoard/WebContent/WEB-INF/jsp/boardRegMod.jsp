<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
  <h1>글쓰기</h1>
	<div>
		<form action="/boardRegmod" id="frm" method="post" onsubmit="return chk()">
			
			<div><input type="text" name="title" placeholder="제목" ></div>
			<div>
				<textarea name="content" placeholder="내용"> </textarea>
			</div>
	
			<div>
				<input type="submit" value="저장">
			</div>
		</form>
	</div>
	<script>
		function chk() {
			if(frm.title.value.length < 2) {
				alert('제목을 작성해 주세요')
				frm.title.focus()
				return false
			} else if(frm.content.value == '') {
				alert('내용을 작성해 주세요')
				frm.content.focus()
				return false
			}
		}
	</script>
</body>
</html>