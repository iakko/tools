package net.iakko.tools.controllers.services.data;

import java.util.ArrayList;
import java.util.List;

public class ErrorEntity
{
	private String			message;
	private List<String>	fields;

	public List<String> getFields()
	{
		if (fields == null)
			fields = new ArrayList<>();
		return fields;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
