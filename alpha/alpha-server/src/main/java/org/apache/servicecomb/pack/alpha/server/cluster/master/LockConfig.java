/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.pack.alpha.server.cluster.master;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class LockConfig {

    private final String serviceName;
    private final String instanceId;
    private final Date lockExpireTime;

    public String getServiceName() {
        return serviceName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public Date getLockExpireTime() {
        return lockExpireTime;
    }

    public LockConfig(String serviceName, String instanceId, int expire) {
        this.serviceName = serviceName;
        this.instanceId = Objects.requireNonNull(instanceId);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MILLISECOND, expire);
        this.lockExpireTime = cal.getTime();
    }

    @Override
    public String toString() {
        return "LockConfig{" +
                "serviceName='" + serviceName + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", lockExpireTime=" + lockExpireTime +
                '}';
    }
}
