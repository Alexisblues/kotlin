/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.jps.build;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class IncrementalLazyCachesTestGenerated extends AbstractIncrementalLazyCachesTest {
    @TestMetadata("jps-plugin/testData/incremental/lazyKotlinCaches")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class LazyKotlinCaches extends AbstractIncrementalLazyCachesTest {
        public void testAllFilesPresentInLazyKotlinCaches() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("jps-plugin/testData/incremental/lazyKotlinCaches"), Pattern.compile("^([^\\.]+)$"), TargetBackend.ANY, true);
        }

        @TestMetadata("class")
        public void testClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/class/");
            doTest(fileName);
        }

        @TestMetadata("classInheritance")
        public void testClassInheritance() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/classInheritance/");
            doTest(fileName);
        }

        @TestMetadata("constant")
        public void testConstant() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/constant/");
            doTest(fileName);
        }

        @TestMetadata("function")
        public void testFunction() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/function/");
            doTest(fileName);
        }

        @TestMetadata("inlineFunctionWithUsage")
        public void testInlineFunctionWithUsage() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/inlineFunctionWithUsage/");
            doTest(fileName);
        }

        @TestMetadata("inlineFunctionWithoutUsage")
        public void testInlineFunctionWithoutUsage() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/inlineFunctionWithoutUsage/");
            doTest(fileName);
        }

        @TestMetadata("noKotlin")
        public void testNoKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/noKotlin/");
            doTest(fileName);
        }

        @TestMetadata("topLevelPropertyAccess")
        public void testTopLevelPropertyAccess() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/lazyKotlinCaches/topLevelPropertyAccess/");
            doTest(fileName);
        }
    }

    @TestMetadata("jps-plugin/testData/incremental/changeIncrementalOption")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class ChangeIncrementalOption extends AbstractIncrementalLazyCachesTest {
        public void testAllFilesPresentInChangeIncrementalOption() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("jps-plugin/testData/incremental/changeIncrementalOption"), Pattern.compile("^([^\\.]+)$"), TargetBackend.ANY, true);
        }

        @TestMetadata("incrementalOff")
        public void testIncrementalOff() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/changeIncrementalOption/incrementalOff/");
            doTest(fileName);
        }

        @TestMetadata("incrementalOffOn")
        public void testIncrementalOffOn() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/changeIncrementalOption/incrementalOffOn/");
            doTest(fileName);
        }

        @TestMetadata("incrementalOffOnJavaChanged")
        public void testIncrementalOffOnJavaChanged() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/changeIncrementalOption/incrementalOffOnJavaChanged/");
            doTest(fileName);
        }

        @TestMetadata("incrementalOffOnJavaOnly")
        public void testIncrementalOffOnJavaOnly() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("jps-plugin/testData/incremental/changeIncrementalOption/incrementalOffOnJavaOnly/");
            doTest(fileName);
        }
    }
}
