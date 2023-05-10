/*
 * Copyright (c) 2023 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.helidon.pico.configdriven.runtime;

import io.helidon.builder.config.spi.ConfigBeanRegistryProvider;
import io.helidon.builder.config.spi.HelidonConfigBeanRegistry;
import io.helidon.common.LazyValue;
import io.helidon.common.Weight;

import static io.helidon.pico.api.ServiceInfoBasics.DEFAULT_PICO_WEIGHT;

/**
 * Service-loaded provider for {@link ConfigBeanRegistry}.
 */
@Weight(DEFAULT_PICO_WEIGHT)
public class DefaultConfigBeanRegistryProvider implements ConfigBeanRegistryProvider {
    static final LazyValue<ConfigBeanRegistry> INSTANCE = LazyValue.create(DefaultPicoConfigBeanRegistry::new);

    /**
     * Service loader based constructor.
     *
     * @deprecated this is a Java ServiceLoader implementation and the constructor should not be used directly
     */
    @Deprecated
    public DefaultConfigBeanRegistryProvider() {
    }

    @Override
    public HelidonConfigBeanRegistry configBeanRegistry() {
        return INSTANCE.get();
    }

}