package com.git.qa.utilties;
import java.io.IOException;

import com.git.qa.base.TestBase;

public class TestUtil extends TestBase {
	public TestUtil() throws IOException {
		super();

	}
	public static long Page_load_Timeout=20;
	public static long Implicit_Wait=10;
	public final String firstRepoName=repoNameSet();
	public final String newRepoName=repoNameSet();
	public String firstRepoURL=prop.getProperty("username")+"/"+firstRepoName;
	public String newRepoURL=prop.getProperty("username")+"/"+newRepoName;

	public String repoNameSet (){

		return "RepoTest"+String.valueOf((int) (Math.random()*1000));
	}

}
