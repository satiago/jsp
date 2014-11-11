function check()
{
	if(form1.username.value == "")
	{
		alert("请填写用户名！");
		form1.username.select();
		return false;
	}
	
	if(form1.password.value == "")
	{
		alert("请填写密码！");
		form1.password.select();
		return false;
	}
	
	return true;
}