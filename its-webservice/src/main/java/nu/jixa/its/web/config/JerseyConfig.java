/*
 * Copyright 2012-2015 the original author or authors.
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

package nu.jixa.its.web.config;

import nu.jixa.its.web.CORSResponseFilter;
import nu.jixa.its.web.RequestFilter;
import nu.jixa.its.web.endpoint.IssueEndpoint;
import nu.jixa.its.web.endpoint.RootEndpoint;
import nu.jixa.its.web.endpoint.TeamsEndpoint;
import nu.jixa.its.web.endpoint.UsersEndpoint;
import nu.jixa.its.web.endpoint.WorkItemEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(UsersEndpoint.class);
    register(WorkItemEndpoint.class);
    register(TeamsEndpoint.class);
    register(IssueEndpoint.class);
    register(CORSResponseFilter.class);
    register(RequestFilter.class);
    register(RootEndpoint.class);
  }
}
