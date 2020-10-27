<!--
 * @Description:
 * @Author: kaitoShy
 * @Date: 2020-10-26 19:47:14
 * @LastEditors: kaitoShy
 * @LastEditTime: 2020-10-27 11:47:02
-->

```bash
java  -Xms512m -Xmx512m -XX:+UseConcMarkSweepGC   -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-26T19:48:02.931-0800: [GC (Allocation Failure) 2020-10-26T19:48:02.931-0800: [ParNew: 139776K->17471K(157248K), 0.0265040 secs] 139776K->52471K(506816K), 0.0265708 secs] [Times: user=0.05 sys=0.10, real=0.02 secs]
2020-10-26T19:48:02.983-0800: [GC (Allocation Failure) 2020-10-26T19:48:02.983-0800: [ParNew: 157247K->17470K(157248K), 0.0224548 secs] 192247K->97578K(506816K), 0.0224893 secs] [Times: user=0.04 sys=0.10, real=0.02 secs]
2020-10-26T19:48:03.030-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.030-0800: [ParNew: 157246K->17469K(157248K), 0.0322620 secs] 237354K->140285K(506816K), 0.0322970 secs] [Times: user=0.21 sys=0.02, real=0.03 secs]
2020-10-26T19:48:03.085-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.085-0800: [ParNew: 157245K->17470K(157248K), 0.0287904 secs] 280061K->184477K(506816K), 0.0288343 secs] [Times: user=0.19 sys=0.02, real=0.03 secs]
2020-10-26T19:48:03.136-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.136-0800: [ParNew: 157246K->17470K(157248K), 0.0322034 secs] 324253K->231324K(506816K), 0.0322382 secs] [Times: user=0.21 sys=0.02, real=0.03 secs]
2020-10-26T19:48:03.169-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 213854K(349568K)] 231735K(506816K), 0.0022235 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-26T19:48:03.171-0800: [CMS-concurrent-mark-start]
2020-10-26T19:48:03.174-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.174-0800: [CMS-concurrent-preclean-start]
2020-10-26T19:48:03.174-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.174-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-26T19:48:03.196-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.196-0800: [ParNew: 157246K->17471K(157248K), 0.0334904 secs] 371100K->281306K(506816K), 0.0335235 secs] [Times: user=0.22 sys=0.03, real=0.03 secs]
2020-10-26T19:48:03.252-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.252-0800: [ParNew: 157247K->17470K(157248K), 0.0333568 secs] 421082K->327804K(506816K), 0.0333914 secs] [Times: user=0.21 sys=0.02, real=0.03 secs]
2020-10-26T19:48:03.306-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.306-0800: [ParNew: 157246K->157246K(157248K), 0.0000181 secs]2020-10-26T19:48:03.306-0800: [CMS2020-10-26T19:48:03.306-0800: [CMS-concurrent-abortable-preclean: 0.003/0.132 secs] [Times: user=0.51 sys=0.05, real=0.13 secs]
 (concurrent mode failure): 310334K->256773K(349568K), 0.0570866 secs] 467580K->256773K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0571654 secs] [Times: user=0.05 sys=0.00, real=0.06 secs]
2020-10-26T19:48:03.381-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.381-0800: [ParNew: 139776K->17469K(157248K), 0.0082504 secs] 396549K->305995K(506816K), 0.0082975 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2020-10-26T19:48:03.390-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 288525K(349568K)] 306576K(506816K), 0.0003865 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.391-0800: [CMS-concurrent-mark-start]
2020-10-26T19:48:03.394-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.394-0800: [CMS-concurrent-preclean-start]
2020-10-26T19:48:03.395-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.395-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-26T19:48:03.418-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.418-0800: [ParNew: 157245K->17470K(157248K), 0.0255037 secs] 445771K->353649K(506816K), 0.0255562 secs] [Times: user=0.14 sys=0.02, real=0.03 secs]
2020-10-26T19:48:03.444-0800: [CMS-concurrent-abortable-preclean: 0.001/0.049 secs] [Times: user=0.17 sys=0.02, real=0.05 secs]
2020-10-26T19:48:03.444-0800: [GC (CMS Final Remark) [YG occupancy: 18082 K (157248 K)]2020-10-26T19:48:03.444-0800: [Rescan (parallel) , 0.0004356 secs]2020-10-26T19:48:03.444-0800: [weak refs processing, 0.0000205 secs]2020-10-26T19:48:03.444-0800: [class unloading, 0.0003141 secs]2020-10-26T19:48:03.445-0800: [scrub symbol table, 0.0004050 secs]2020-10-26T19:48:03.445-0800: [scrub string table, 0.0001590 secs][1 CMS-remark: 336178K(349568K)] 354260K(506816K), 0.0014223 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.445-0800: [CMS-concurrent-sweep-start]
2020-10-26T19:48:03.446-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.446-0800: [CMS-concurrent-reset-start]
2020-10-26T19:48:03.446-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.468-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.469-0800: [ParNew: 157246K->157246K(157248K), 0.0000170 secs]2020-10-26T19:48:03.469-0800: [CMS: 297005K->299558K(349568K), 0.0523191 secs] 454252K->299558K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0523898 secs] [Times: user=0.05 sys=0.00, real=0.06 secs]
2020-10-26T19:48:03.521-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 299558K(349568K)] 299935K(506816K), 0.0001445 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.521-0800: [CMS-concurrent-mark-start]
2020-10-26T19:48:03.524-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.524-0800: [CMS-concurrent-preclean-start]
2020-10-26T19:48:03.524-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.524-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-26T19:48:03.546-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.546-0800: [ParNew: 139776K->17468K(157248K), 0.0070852 secs] 439334K->348095K(506816K), 0.0071158 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
2020-10-26T19:48:03.554-0800: [CMS-concurrent-abortable-preclean: 0.001/0.030 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2020-10-26T19:48:03.554-0800: [GC (CMS Final Remark) [YG occupancy: 24046 K (157248 K)]2020-10-26T19:48:03.554-0800: [Rescan (parallel) , 0.0002719 secs]2020-10-26T19:48:03.554-0800: [weak refs processing, 0.0000097 secs]2020-10-26T19:48:03.554-0800: [class unloading, 0.0002776 secs]2020-10-26T19:48:03.555-0800: [scrub symbol table, 0.0004439 secs]2020-10-26T19:48:03.555-0800: [scrub string table, 0.0001726 secs][1 CMS-remark: 330626K(349568K)] 354673K(506816K), 0.0012352 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.555-0800: [CMS-concurrent-sweep-start]
2020-10-26T19:48:03.556-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.556-0800: [CMS-concurrent-reset-start]
2020-10-26T19:48:03.556-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.578-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.578-0800: [ParNew: 157244K->157244K(157248K), 0.0000172 secs]2020-10-26T19:48:03.578-0800: [CMS: 330626K->330182K(349568K), 0.0564013 secs] 487871K->330182K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0564741 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-26T19:48:03.634-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 330182K(349568K)] 330326K(506816K), 0.0002114 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.634-0800: [CMS-concurrent-mark-start]
2020-10-26T19:48:03.636-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.636-0800: [CMS-concurrent-preclean-start]
2020-10-26T19:48:03.636-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.636-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-26T19:48:03.654-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.654-0800: [ParNew: 139776K->139776K(157248K), 0.0000180 secs]2020-10-26T19:48:03.654-0800: [CMS2020-10-26T19:48:03.654-0800: [CMS-concurrent-abortable-preclean: 0.000/0.018 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
 (concurrent mode failure): 330182K->327506K(349568K), 0.0551668 secs] 469958K->327506K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0552326 secs] [Times: user=0.06 sys=0.00, real=0.05 secs]
2020-10-26T19:48:03.730-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.730-0800: [ParNew: 139635K->139635K(157248K), 0.0000173 secs]2020-10-26T19:48:03.730-0800: [CMS: 327506K->339300K(349568K), 0.0611000 secs] 467142K->339300K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0611629 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-26T19:48:03.792-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 339300K(349568K)] 339595K(506816K), 0.0001374 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.792-0800: [CMS-concurrent-mark-start]
2020-10-26T19:48:03.793-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.793-0800: [CMS-concurrent-preclean-start]
2020-10-26T19:48:03.793-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.793-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-26T19:48:03.793-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.794-0800: [GC (CMS Final Remark) [YG occupancy: 15511 K (157248 K)]2020-10-26T19:48:03.794-0800: [Rescan (parallel) , 0.0002129 secs]2020-10-26T19:48:03.794-0800: [weak refs processing, 0.0000112 secs]2020-10-26T19:48:03.794-0800: [class unloading, 0.0002206 secs]2020-10-26T19:48:03.794-0800: [scrub symbol table, 0.0003737 secs]2020-10-26T19:48:03.794-0800: [scrub string table, 0.0001797 secs][1 CMS-remark: 339300K(349568K)] 354811K(506816K), 0.0010393 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.795-0800: [CMS-concurrent-sweep-start]
2020-10-26T19:48:03.795-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.795-0800: [CMS-concurrent-reset-start]
2020-10-26T19:48:03.795-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.812-0800: [GC (Allocation Failure) 2020-10-26T19:48:03.812-0800: [ParNew: 139776K->139776K(157248K), 0.0000176 secs]2020-10-26T19:48:03.812-0800: [CMS: 339300K->344733K(349568K), 0.0627160 secs] 479076K->344733K(506816K), [Metaspace: 2728K->2728K(1056768K)], 0.0627810 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-26T19:48:03.875-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 344733K(349568K)] 345234K(506816K), 0.0002154 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-26T19:48:03.876-0800: [CMS-concurrent-mark-start]
执行结束!共生成对象次数:8428
Heap
 par new generation   total 157248K, used 6072K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   4% used [0x00000007a0000000, 0x00000007a05ee2a8, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 concurrent mark-sweep generation total 349568K, used 344733K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2734K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```