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
  if (validate_required(photo,"请选择上传的照片!")==false)
    {photo.focus();return false}
  else if (validate_required(goodsname,"商品名称不能为空!")==false)
  {goodsname.focus();return false}
  else if (validate_required(price,"请输入商品价格!")==false)
  {price.focus();return false}
  else if (validate_required(num,"商品数量不能为空!")==false)
  {num.focus();return false}
  else if (validate_required(goodsintro,"请简单介绍下商品!")==false)
  {goodsintro.focus();return false}
  }

 
}