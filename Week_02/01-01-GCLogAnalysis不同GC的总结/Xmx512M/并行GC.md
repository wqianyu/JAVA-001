<!--
 * @Description:
 * @Author: kaitoShy
 * @Date: 2020-10-26 19:43:50
 * @LastEditors: kaitoShy
 * @LastEditTime: 2020-10-26 23:10:16
-->

```bash
$ java  -Xms512m -Xmx512m   -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
---
正在执行...
2020-10-26T19:43:14.695-0800: [GC (Allocation Failure) [PSYoungGen: 131531K->21486K(153088K)] 131531K->41798K(502784K), 0.0192696 secs] [Times: user=0.02 sys=0.09, real=0.02 secs]
2020-10-26T19:43:14.738-0800: [GC (Allocation Failure) [PSYoungGen: 153070K->21490K(153088K)] 173382K->89014K(502784K), 0.0300074 secs] [Times: user=0.03 sys=0.15, real=0.03 secs]
2020-10-26T19:43:14.790-0800: [GC (Allocation Failure) [PSYoungGen: 153074K->21495K(153088K)] 220598K->130947K(502784K), 0.0216138 secs] [Times: user=0.04 sys=0.09, real=0.02 secs]
2020-10-26T19:43:14.837-0800: [GC (Allocation Failure) [PSYoungGen: 153079K->21500K(153088K)] 262531K->171834K(502784K), 0.0213011 secs] [Times: user=0.04 sys=0.09, real=0.02 secs]
2020-10-26T19:43:14.882-0800: [GC (Allocation Failure) [PSYoungGen: 153084K->21497K(153088K)] 303418K->214436K(502784K), 0.0248176 secs] [Times: user=0.05 sys=0.09, real=0.02 secs]
2020-10-26T19:43:14.927-0800: [GC (Allocation Failure) [PSYoungGen: 152707K->21503K(80384K)] 345646K->258456K(430080K), 0.0274494 secs] [Times: user=0.05 sys=0.12, real=0.03 secs]
2020-10-26T19:43:14.962-0800: [GC (Allocation Failure) [PSYoungGen: 79918K->37192K(116736K)] 316870K->278312K(466432K), 0.0048724 secs] [Times: user=0.02 sys=0.01, real=0.00 secs]
2020-10-26T19:43:14.976-0800: [GC (Allocation Failure) [PSYoungGen: 96072K->49975K(116736K)] 337192K->296851K(466432K), 0.0108818 secs] [Times: user=0.05 sys=0.02, real=0.01 secs]
2020-10-26T19:43:14.997-0800: [GC (Allocation Failure) [PSYoungGen: 108855K->57850K(116736K)] 355731K->317701K(466432K), 0.0147624 secs] [Times: user=0.07 sys=0.02, real=0.02 secs]
2020-10-26T19:43:15.024-0800: [GC (Allocation Failure) [PSYoungGen: 116669K->39874K(116736K)] 376520K->334450K(466432K), 0.0205219 secs] [Times: user=0.04 sys=0.09, real=0.02 secs]
2020-10-26T19:43:15.044-0800: [Full GC (Ergonomics) [PSYoungGen: 39874K->0K(116736K)] [ParOldGen: 294575K->242739K(349696K)] 334450K->242739K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0394794 secs] [Times: user=0.22 sys=0.01, real=0.04 secs]
2020-10-26T19:43:15.096-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->18709K(116736K)] 301619K->261448K(466432K), 0.0020551 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.109-0800: [GC (Allocation Failure) [PSYoungGen: 77140K->21950K(116736K)] 319879K->283072K(466432K), 0.0047798 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.125-0800: [GC (Allocation Failure) [PSYoungGen: 80519K->20416K(116736K)] 341641K->302154K(466432K), 0.0049461 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.141-0800: [GC (Allocation Failure) [PSYoungGen: 79296K->22669K(116736K)] 361034K->323632K(466432K), 0.0066504 secs] [Times: user=0.02 sys=0.02, real=0.00 secs]
2020-10-26T19:43:15.148-0800: [Full GC (Ergonomics) [PSYoungGen: 22669K->0K(116736K)] [ParOldGen: 300963K->269430K(349696K)] 323632K->269430K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0392854 secs] [Times: user=0.23 sys=0.00, real=0.04 secs]
2020-10-26T19:43:15.196-0800: [GC (Allocation Failure) [PSYoungGen: 58652K->22767K(116736K)] 328082K->292197K(466432K), 0.0045232 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.211-0800: [GC (Allocation Failure) [PSYoungGen: 81647K->20241K(116736K)] 351077K->310494K(466432K), 0.0048904 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.229-0800: [GC (Allocation Failure) [PSYoungGen: 79121K->22023K(116736K)] 369374K->330936K(466432K), 0.0096422 secs] [Times: user=0.03 sys=0.03, real=0.01 secs]
2020-10-26T19:43:15.239-0800: [Full GC (Ergonomics) [PSYoungGen: 22023K->0K(116736K)] [ParOldGen: 308912K->284242K(349696K)] 330936K->284242K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0406561 secs] [Times: user=0.21 sys=0.00, real=0.04 secs]
2020-10-26T19:43:15.293-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->18926K(116736K)] 343122K->303169K(466432K), 0.0019730 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.304-0800: [GC (Allocation Failure) [PSYoungGen: 77462K->25415K(116736K)] 361705K->327994K(466432K), 0.0042163 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.317-0800: [GC (Allocation Failure) [PSYoungGen: 84201K->22459K(116736K)] 386779K->348413K(466432K), 0.0095136 secs] [Times: user=0.02 sys=0.04, real=0.01 secs]
2020-10-26T19:43:15.326-0800: [Full GC (Ergonomics) [PSYoungGen: 22459K->0K(116736K)] [ParOldGen: 325954K->299501K(349696K)] 348413K->299501K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0439032 secs] [Times: user=0.23 sys=0.00, real=0.05 secs]
2020-10-26T19:43:15.379-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->19344K(116736K)] 358381K->318845K(466432K), 0.0025469 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.389-0800: [GC (Allocation Failure) [PSYoungGen: 78192K->17467K(116736K)] 377694K->334777K(466432K), 0.0034697 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.392-0800: [Full GC (Ergonomics) [PSYoungGen: 17467K->0K(116736K)] [ParOldGen: 317309K->303536K(349696K)] 334777K->303536K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0449896 secs] [Times: user=0.26 sys=0.01, real=0.04 secs]
2020-10-26T19:43:15.446-0800: [GC (Allocation Failure) [PSYoungGen: 58680K->21943K(116736K)] 362216K->325479K(466432K), 0.0022837 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.456-0800: [GC (Allocation Failure) [PSYoungGen: 80756K->20108K(116736K)] 384293K->344705K(466432K), 0.0044770 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-26T19:43:15.461-0800: [Full GC (Ergonomics) [PSYoungGen: 20108K->0K(116736K)] [ParOldGen: 324596K->312697K(349696K)] 344705K->312697K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0435186 secs] [Times: user=0.25 sys=0.00, real=0.04 secs]
2020-10-26T19:43:15.513-0800: [GC (Allocation Failure) [PSYoungGen: 58723K->19175K(116736K)] 371420K->331872K(466432K), 0.0051870 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.527-0800: [GC (Allocation Failure) [PSYoungGen: 77951K->18443K(116736K)] 390648K->350110K(466432K), 0.0079128 secs] [Times: user=0.03 sys=0.02, real=0.01 secs]
2020-10-26T19:43:15.535-0800: [Full GC (Ergonomics) [PSYoungGen: 18443K->0K(116736K)] [ParOldGen: 331667K->314631K(349696K)] 350110K->314631K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0384950 secs] [Times: user=0.23 sys=0.00, real=0.04 secs]
2020-10-26T19:43:15.585-0800: [GC (Allocation Failure) [PSYoungGen: 58338K->24967K(116736K)] 372970K->339598K(466432K), 0.0034288 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-26T19:43:15.596-0800: [GC (Allocation Failure) [PSYoungGen: 83847K->19635K(116736K)] 398478K->358720K(466432K), 0.0097166 secs] [Times: user=0.06 sys=0.02, real=0.01 secs]
2020-10-26T19:43:15.606-0800: [Full GC (Ergonomics) [PSYoungGen: 19635K->0K(116736K)] [ParOldGen: 339084K->320935K(349696K)] 358720K->320935K(466432K), [Metaspace: 2728K->2728K(1056768K)], 0.0426728 secs] [Times: user=0.26 sys=0.00, real=0.04 secs]
执行结束!共生成对象次数:7932
Heap
 PSYoungGen      total 116736K, used 2629K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b5811440,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
  to   space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
 ParOldGen       total 349696K, used 320935K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 91% used [0x00000007a0000000,0x00000007b3969d80,0x00000007b5580000)
 Metaspace       used 2734K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```