/*
 * Created on Jun 5, 2005
 */
package com.openedit.generators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.openedit.Generator;
import com.openedit.OpenEditException;
import com.openedit.WebPageRequest;
import com.openedit.page.Page;
import com.openedit.util.PathUtilities;

/**
 * @author cburkey
 *
 */
public class GeneratorWithAcceptFilter extends BaseGenerator
{
	protected Generator fieldGenerator;
	protected List fieldAccepts;
	public GeneratorWithAcceptFilter(Generator inGen, String inFiles)
	{
		setGenerator(inGen);
		List types = Arrays.asList(inFiles.split(","));
		setAccepts(types);
	}
	
	public void generate(WebPageRequest inContext, Page inPage, Output inOut) throws OpenEditException
	{
		getGenerator().generate(inContext,inPage, inOut);
	}

	public Generator getGenerator()
	{
		return fieldGenerator;
	}
	public void setGenerator(Generator inGenerator)
	{
		fieldGenerator = inGenerator;
	}
	public List getAccepts()
	{
		return fieldAccepts;
	}
	public void setAccepts(List inMimeTypes)
	{
		fieldAccepts = inMimeTypes;
	}
	
	public boolean canGenerate(WebPageRequest inReq)
	{
		String path = inReq.getPage().getContentItem().getActualPath();
		for (Iterator iter = getAccepts().iterator(); iter.hasNext();)
		{
			String mtype = (String) iter.next();
			if ( PathUtilities.match(path,mtype))
			{
				return true;
			}
			
		}
		return false;
	}

}
