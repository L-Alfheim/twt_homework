# 电力管理系统作业

这是一个独立的 Java 17 / Maven 作业项目，只实现电力管理模块，不需要依赖飞船内核、事件总线、存档或游戏循环。

## 开始作业

1. 从 `src/main/java` 的接口、类型声明和 TODO 注释开始实现。
2. 运行 `mvn test`，根据失败用例逐步完成行为。
3. 完成入口程序后运行 `mvn exec:java`（也可以直接从 IDE 运行 `PowerManagementDemo`）。

当前 `src/main/java` 是未完成的起步框架，所以初次运行测试会失败；这是预期的，测试是作业验收标准，不是参考答案。不要删除或修改 `src/test/java` 中的验收测试。

## 作业范围

- 实现发电、用电设备接口及设备类，设备可启用和停用。
- 电力总线以 `List<接口类型>` 保存设备，计算启用设备的发电量、耗电量。
- 使用 `PowerState` 和 `PowerReport` 表示供需状态与报告。
- 校验空名称、负功率和 null 注册参数，使用 SLF4J 记录注册与供需结果。
- 让 `mvn test` 全部通过，并让入口程序展示过剩、短缺等状态。

是否使用 `PowerDevice` 抽象父类由你决定。作业要求通过接口、多态、集合、异常处理和日志完成独立程序；不要把项目中的 `ElectricBus`、内核或其他模块复制进来。

## 日志验收

自动化测试集中检查设备行为、异常和供需结果。日志内容与级别请在运行入口时确认：成功注册使用 `info`，短缺使用 `warn`，入口捕获非法参数时使用 `error`。

## 提交作业

请在自己的分支完成作业，不要直接提交到主分支。进入项目目录后创建新分支，将 student-id 替换为网名：

```
git switch -c homework/student-id
```

完成作业并确认 mvn test 通过后，提交并推送分支：

```
git add .
git commit -m "Complete electric power management homework"
git push -u origin homework/student-id
```

然后向仓库的默认分支创建 Pull Request（PR）。请在 PR 说明中填写姓名或学号、实现内容和测试结果。