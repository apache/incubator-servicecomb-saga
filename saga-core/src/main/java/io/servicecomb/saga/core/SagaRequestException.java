/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.saga.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.servicecomb.saga.core.application.interpreter.JsonSagaRequest;

public class SagaRequestException {
  private final SagaRequest request;
  private final SagaResponse response;

  public SagaRequestException(
      @JsonProperty("request") JsonSagaRequest request,
      @JsonProperty("response") FailedSagaResponse response) {
    this.request = request;
    this.response = response;
  }

  public SagaRequestException(SagaRequest request, SagaResponse response) {
    this.request = request;
    this.response = response;
  }

  public SagaRequest request() {
    return request;
  }

  public SagaResponse response() {
    return response;
  }
}
