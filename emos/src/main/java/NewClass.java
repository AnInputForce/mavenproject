
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.bean.Issue;
import java.util.List;

/*
 * Copyright 2013 待到道成日，纵横天地间.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author Kang.Cunhua
 */
public class NewClass {

  private static String redmineHost = "https://www.hostedredmine.com";
  private static String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
  private static String projectKey = "taskconnector-test";
  private static Integer queryId = null; // any

  public static void main(String[] args) {
    RedmineManager mgr = new RedmineManager(redmineHost, apiAccessKey);
    try {
      tryGetIssues(mgr);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void tryGetIssues(RedmineManager mgr) throws Exception {
    List<Issue> issues = mgr.getIssues(projectKey, queryId);
    for (Issue issue : issues) {
      System.out.println(issue.toString());
    }
  }
}
