#Offline instrumentation (Clover) demo project

This is a demo project to hack the Gradle Clover plugin in order to see the instrumented files.

Basically, the Clover plugin does the followings:
 1. Instrument and Compile the code + it backs up the original (not instrumented) class files
 2. Run the tests (instrumented code will track the execution data)
 3. Create coverage snapshot
 4. Restore the original class files, backed up in the first step

You can check this in the [source code of Clover Plugin](https://github.com/bmuschko/gradle-clover-plugin/blob/master/src/main/groovy/com/bmuschko/gradle/clover/CloverPlugin.groovy).
You should see something like this:
```groovy
private void configureActionsForTask(Test test, Project project, CloverPluginConvention cloverPluginConvention, AggregateDatabasesTask aggregateDatabasesTask) {
    test.classpath += project.configurations.getByName(CONFIGURATION_NAME).asFileTree
    OptimizeTestSetAction optimizeTestSetAction = createOptimizeTestSetAction(cloverPluginConvention, project, test)
    test.doFirst optimizeTestSetAction // add first, gets executed second
    test.doFirst createInstrumentCodeAction(cloverPluginConvention, project, test) // add second, gets executed first
    test.include optimizeTestSetAction // action is also a file inclusion spec
    test.doLast createCreateSnapshotAction(cloverPluginConvention, project, test)
    test.doLast createRestoreOriginalClassesAction(cloverPluginConvention, project, test)
    aggregateDatabasesTask.aggregate(test)
}
```
From our perspective, this line is the interesting one:
```groovy
test.doFirst createInstrumentCodeAction(cloverPluginConvention, project, test) // add second, gets executed first
```
This creates a [Gradle **Action**](https://docs.gradle.org/current/dsl/org.gradle.api.Task.html) which will instrument the code and which will run before the tests. We only need to stop the task after this action but before the restoration of the original files:
```groovy
test.doLast createRestoreOriginalClassesAction(cloverPluginConvention, project, test)
```
I picked a not too complicated solution which will stop the processing after the instrumentation, so that the restoration won't happen:
```groovy
test.doFirst { throw new Exception('Clover hack to see the instrumented .class files') }
```
See: [`clover.gradle`](gradle/clover.gradle)

In order to try this out, you only need to:
  1. Get a Clover license, see [`clover.gradle`](gradle/clover.gradle)
  2. Uncomment applying the Clover plugin in [`build.gradle`](build.gradle)
  3. Run `./gradlew clover` (will fail) and check the .class files in `build/classes/main` and `build/classes/main-bak`
