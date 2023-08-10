# 搭建计算机科学系统知识架构--数据结构与算法

在学习过程中,我发现写的都是工具的使用方法都是碎片化的知识,从来没有从系统层面去思考问题并形成自己的知识树,之前我很努力但是事倍功半,现在我要综合前面学习的知识搭建自己的计算机科学知识架构。为什么学习数据结构和算法？因为我发现所有的框架和工具包括计算机底层到处都是数据结构的影子,就像HTML元素其实底层是一棵树,就像区块链、ChatGpt这些最新的概念也是数据结构,于是我决定记录自己的学习过程并编写写成一个个小的Demo录制上传B站,以下是我录制的章节以及视频号。<br>

https://space.bilibili.com/3493132727487288/channel/series

<body>
    <div>
        <h2>基础数据结构练习(data-structure)</h2>
        <div>
            <ul>
                <li>
                    <h3>数组练习</h3>
                    <ul>
                        <li>
                            <div>
                                <div>
                                    <h4>DynamicList</h4>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;模拟List集合下的ArrayList,ArrayList的本质是对一个数组进行操作,我们平时在定义的数组的时候通常会定义数组的大小,ArrayList在底层也会定义一个默认长度的数组这里假设可存储元素为10,当超过数组下标时,通常会报错,但是ArrayList通过巧妙地数学概念扩容缩容阈值动态的变更数组的大小（这里提一嘴,想要互联网金字塔的顶端,学好数学至关重要）,所以用户感觉不到ArrayList底层的数组。
                            </div>
                        </li>
                        <li>
                            <div>
                                <div>
                                    <h4>LeetCode 剑指 Offer 05. 替换空格</h4>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的思路:这道题如果使用Java 8来写,Java
                                8中String字符串是包装类,要想得到那个空格必须要遍历数组中所有的元素,要将类中每一个字符单独拿出来判断,那就要给这些字符一个容器,这个容器一定是数组,为什么不是链表？因为链表查询起来比数组慢,又因为Java
                                8的String包装类底层就是char[]数组,所以我想到有String类自带的replaceAll方法,但是最终提交上去时间空间复杂度都不理想。于是我放弃使用String类中的方法,而是将String转为char[],新建一个char[]容器来承载它,这种方法空间复杂度不理想。最后我用了StringBuffer来作为这个容器,StringBuffer时间和空间复杂度都非常理想。通过这个题我总结出一下几点:1.StringBuffer在这道题的解法中比StringBuilder占空间小很多。2.第一次指导char[]数组转为String,可以用new
                                String();的方式。3.熟悉了String类中的各种方法的使用。
                            </div>
                        </li>
                    </ul>
                </li>
                <li>
                    <h3>链表练习</h3>
                    <ul>
                        <li>
                            <div>
                                <div>
                                    <h4>SimpleLinkedList</h4>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List集合下面除了有由数组实现的ArrayList,还有用链表实现的LinkedList,LinkedList底层核心是一个内部类Node,Node中保存每个链表的数据,以及下个链表的地址,在Java中没有指针的概念,地址是可以传递的,前面说的是单链表,除了单链表还有双链表、循环链表等等,链表的特性就是增加删除速度快,查询慢,这与链表的特性有关,数组是一组连续的内存空间（虚拟内存,其实在真正的物理上不一定连续）,链表存储在不同的位置,在编写LinkedList时,只感觉到这一块有所不同,其他其实相差不大。
                            </div>
                        </li>
                        <li>
                            <div>
                                <div>
                                    <h4>LeetCode 剑指 Offer 06. 从尾到头打印链表</h4>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这道题主要核心是考察递归思想,我的思路:首先要将链表倒过来用数组来表示,那就一定要有一个数组容器,那就需要知道链表的长度,起初我打算用ArrayList来实现(ArrayList底层有扩容缩容机制),因为ArrayList只支持包装类型,所以弃用,后来才想到Java具有自动拆装箱功能,于是又启用,但是性能真的不如自己定义int[]基本类型数组</br></br>
                                1.自己定义一个int[]基本类型数组作为容器,并利用递归思想。这个方法时间和空间复杂度最佳</br>
                                2.使用ArrayList这里有一个问题,ArrayList只支持包装类型,这里涉及到Java的自动拆装箱特性。用了ArrayList时间复杂度增加,可见Java这些包装类真的不如C或者C++那种语言快,Java是牺牲了性能来换他的全局性</br>
                                3.这个方法很有意思使用LinkedList的特性来模拟Stack栈,这种方法甚至不用写递归,但是时间和空间复杂度一般。
                            </div>
                        </li>
                    </ul>
        </div>
        </li>
        </ul>
        </li>
        </ul>
    </div>
    </div>
</body>