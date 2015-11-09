function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(auctionphoto,"请选择上传的照片!")==false)
    {auctionphoto.focus();return false}
  else if (validate_required(auctionname,"商品名称不能为空!")==false)
  {auctionname.focus();return false}
  else if (validate_required(startprice,"请输入商 品 拍卖底价!")==false)
  {startprice.focus();return false}
  else if (validate_required(expectprice,"请输入商 品 期待价格!")==false)
  {expectprice.focus();return false}
  else if (validate_required(auctionintro,"请简单介绍下商品!")==false)
  {auctionintro.focus();return false}
  }

 
}