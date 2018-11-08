/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package com.st.cloud.commom.keygen;

/**
 * Key generator factory.
 * 
 * @author ShangTao
 */
public final class KeyGeneratorFactory {
    
    /**
     * Create key generator.
     * 
     * @param keyGeneratorClassName key generator class name
     * @return key generator instance
     */
    public static KeyGenerator newInstance(final String keyGeneratorClassName) {
        try {
            return (KeyGenerator) Class.forName(keyGeneratorClassName).newInstance();
        } catch (final ReflectiveOperationException ex) {
            throw new IllegalArgumentException(String.format("Class %s should have public privilege and no argument constructor", keyGeneratorClassName));
        }
    }
}