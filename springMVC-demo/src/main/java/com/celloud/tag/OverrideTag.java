package com.celloud.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 自定义标签，用于在jsp模板中重写指定的占位内容
 * 
 * 基本原理： 将overwrite标签内容部分添加到ServletRequest的attribute属性中
 * 在后续block标签中再通过属性名读取出来，将其渲染到最终的页面上即可
 * 
 * @author badqiu
 *
 */
public class OverrideTag extends BodyTagSupport {

	private static final long serialVersionUID = -8379959647039117369L;

	private String name;
	private boolean pjax;

	@Override
	public int doStartTag() throws JspException {
		return isOverrided() ? SKIP_BODY : EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		if (isOverrided()) {
			return EVAL_PAGE;
		}
		BodyContent b = getBodyContent();
		String varName = Utils.getOverrideVariableName(name);
		if(pjax){
			try {
				pageContext.getOut().write(b.getString());
			} catch (IOException e) {
				throw new JspException("write overridedContent occer IOException,block name:" + name, e);
			}
		}else{
			pageContext.getRequest().setAttribute(varName, b.getString());
		}
		return EVAL_PAGE;
	}

	private boolean isOverrided() {
		String varName = Utils.getOverrideVariableName(name);
		return pageContext.getRequest().getAttribute(varName) != null;
	}

	public void setPjax(boolean pjax) {
		this.pjax = pjax;
	}

	public void setName(String name) {
		this.name = name;
	}
}
