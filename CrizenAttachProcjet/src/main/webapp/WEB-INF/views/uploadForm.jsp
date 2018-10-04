<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<style type="text/css">
iframe {
	width: 400px;
	height: 200px;
	border: 1px;
	border-style: solid;
}

</style>
</head>
<body>
	<form id="form1" action="fileupload.do" method="post"
		enctype="multipart/form-data" target="iframe1">
		<table>
			<tr>
				<th>파일</th>
				<td><input type="file" name="uploadFile" /></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-default" value="업로드"></td>
				<td><input type="reset" class="btn btn-default" value="취소"></td>
			</tr>
			<tr>
				<td><input type="text" name="memo" placeholder="메모"></td>
			</tr>
			<tr>
				<!-- <td><a href="filedownload.do">다운로드</a></td> -->
				<td><a href="./profile.do"> 이미지 확인</a></td>
			</tr>
		</table>
	</form>
	<iframe name="iframe1"></iframe>
</body>
</html>