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

package io.servicecomb.saga.alpha.server;

import java.util.List;
import java.util.stream.Collectors;

import io.servicecomb.saga.alpha.core.TxEvent;
import io.servicecomb.saga.alpha.core.TxEventRepository;

class SpringTxEventRepository implements TxEventRepository {
  private final TxEventEnvelopeRepository eventRepo;

  SpringTxEventRepository(TxEventEnvelopeRepository eventRepo) {
    this.eventRepo = eventRepo;
  }

  @Override
  public void save(TxEvent event) {
    eventRepo.save(new TxEventEnvelope(event));
  }

  @Override
  public List<TxEvent> findCompletedEvents(String globalTxId, String type) {
    return eventRepo.findByEventGlobalTxIdAndEventType(globalTxId, type)
        .stream()
        .map(TxEventEnvelope::event)
        .collect(Collectors.toList());
  }
}
