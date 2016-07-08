package org.openedit.modules.translations;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LanguageMap extends TreeMap
{

	public LanguageMap(Map inVals)
	{
		super(inVals);
	}
	
	public LanguageMap()
	{
	}

	public String getText(String inLocale){
		
		String val = (String) get(inLocale);
		return val;
		
		
	}

	public void setText(String inVal, String inLocale)
	{
		put(inLocale, inVal); 
	}
	
	@Override
	public String toString()
	{
		StringBuffer values = new StringBuffer();
		for (Iterator iterator = keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			values.append(get(key));
			if( iterator.hasNext() )
			{
				values.append(" ");
			}
		}
		return values.toString();
		
	}
	
	
}