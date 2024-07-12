# Compose
Learning Compose
# 声明式UI
> 不需要手动更新页面，声明过变量之后页面会自动更新，其他的就是命令式，传统setText方式

# 布局对应
1. FrameLayout RelativeLayout--- Box()
2. LinearLayout --- Column() / Row()
3. ConstraintLayout -- MotionLayout -- Jetpack
4. RecyclerView -- Jetpack -- LazyColumn() / LazyRow()
5. ScrollView -- Modifier.verticalScroll() / horizontalScroll()
6. ViewPager -- Jetpack -- Pager()

# Modifier的两个特性
1. 顺序敏感，按顺序调用，同样的 api，不同的顺序，就是不同的效果，这就是 Compose 中 padding 可以替代原生的 margin 与 padding
2. 不会覆盖相同的 api，多次调用 api，会依次应用

** 通用的设置用 Modifier，专项的设置用函数参数 **
例如：clickable属于通用设置，so在 Modifier 中，除了Button有额外的 onClick参数，Button生来就是为了点击，主要是为了方便开发者，底部实现还是 Modifier

## 注意
> Compose padding 一鱼两吃
1. padding 与 margin 内边距与外边距是相对背景来说的，padding 包括背景，margin 不包括背景
2. Modifier.padding().background() -- 不包括背景 margin
3. Modifier.background().padding() -- 包括背景 padding

# Compose 依赖库
material(3) -- Button()
                         ----material-icons-extended
foundation -- Row/Column ----material-icons-core
animation
ui -- layout
runtime -- remember/mutableStateOf
------
compiler
## 三条原则
1. 写代码的时候，依赖 material（3）就够了；如果跳过 material依赖foundation 就够了
2. 如果你需要ui-tooling，需要单独把它写出来
3. 如果你需要material-icons-extended，必须专门列出来

# 自定义Composable 布局可控
> Compose的编译器插件（Compose Plugin） @Composable 识别符，【加了@Composable注解的函数】【Composable】【Composable函数】
> 面向切面编程（AOP）1. Annotation Processor 注解处理器 2. 修改字节码   都是java环境jvm的功能

使用场景：
1. 自定义View + xml布局文件
2. 自定义View：自定义绘制、布局、触摸反馈 onDraw() onMeasure() onLayout() onTouchEvent()

# MutableState 与 mutableStateOf() 实现变量自动刷新
> 核心：返回MutableState对象，MutableState的get()与set()都是定制过得，在读的时候，自动产生订阅行为，写的时候，自动触发刷新并且变量新值的应用也会触发刷新

> 刷新：组合（组合过程：拼凑出界面实际内容，官方表达Composition，先Compose，ComposeView,AndroidComposeView,LayoutNode,LayoutNode-LayoutNode）
> 布局
> 绘制

MutableState -> StateObject -> StateRecord -> Compose支持**事务**功能(支持撤销功能，回滚)
链表：List 保存新旧值，只需要保存[头结点]就行
User:1. Array 2. User(nextUser:User)[头结点]
第二个：head.nextUser
第五个：head.nextUser.nextUser.nextUser.nextUser
---
Recompose:重组
readable() 三参数版本：遍历StateRecord链表，找到一个可用堆最新的StateRecord

StateRecord:变量
Snapshot：整个状态；可以对应多个StateRecord；一个StateRecord对应一个SnapShot
1. 系统有多个Snapshot的时候，它们是有先后关系的
2. 同一个StateObject的每个StateRecord，都有它们对应的Snapshot的id
3. StateRecord和Snapshot就算不直接对应，只要StateRecord的Snapshot对另一个有效，另一个就能取到这个StateRecord
4. Snapshot id:2可以取到Snapshot id:1，虽然2没有StateRecord，但可以取1的StateRecord

两个订阅过程：
1. 对Snapshot中读写StateObject对象的订阅，分别订阅读和写，所以有两个接受者：readObserver和writeObserver（只有在组合过程中的写事件，才会触发writeObserver）。
发生时间：订阅是在Snapshot创建的时候；通知是在：读和写的时候。
2. 对每一个StateObject的应用做订阅。（非组合过程，写事件会触发回调）
发生时间：订阅是在：第一个订阅的readObserver被调用（通知）的时候；通知是在：StateObject新值被应用的时候。旧值会被标记为失效，通知刷新

> 旧值会被标记为失效，通知刷新，重组之后会不会刷新取决于组合有没有改变
get():记录读
set():标记失效
[应用]事件：标记失效

**注意： 委托：by，委托（代理）的是里面的值（类型）[getValue()/setValue()]；= ：赋值，直接赋值（该类型）**

# 重组作用域与remember()
> 运行时拿到某行代码：【反射->字节码】不算 不可行
> 优势：比别人懂，比别人快，比别人稳，还能帮别人解决问题

Recompose Scope:重组作用域
remember：缓存策略，拿到**老对象**；起到缓存作用，防止多次初始化；var全部包上就对了。
remember(key....): key有变化，{}重新计算，新的结果缓存下来；无变化用缓存，旧值

# 「无状态」、状态提升和单向数据流

> 无状态：Stateless--不是个功能，是个特点  「状态」：控件属性
> State Hoisting：状态提升，作为参数，到上一层组件 原则：尽量不往上提

1. TextField ：material的 不是foundation或者ui里面的，不可定制
2. BasicTextField ： foundation或者ui里面的，可定制

Compose: 所有页面中用到的数据都是**单向数据流**，发生事件，lamda回调给上层
> 单向数据流: 数据从上往下传递，事件从下往上传递，不存在组件内部事件自动修改数据的机制

# List mutableStateOf(mutableListof(1,2,3))不会触发刷新，状态机制的背后
> Compose会对赋值行为（对象改变）做监听,进行代码块重组，页面刷新
> MutableState：是否重新赋值
> 不重新赋值监听改变：mutableStateListOf()/mutableStateMapOf()

var num by mutableStateOf():读的时候会注册监听； 「写」的时候会去标记失效，实现刷新，进行代码块重组
注意：
1. 组合过程中，发生写，赋值，会把用到这个值的地方直接标记无效；
2. 组合完成之后，发生写，**赋值（修改了对象引用**），需要等新值**应用**之后，才会把用到这个值的地方标记无效

val numList = mutableStateListOf(1,2,3,4) -> mutableList<Int>
val numMap = mutableStateMapOf(1 to "one", 2 to "two")

# Recompose重组的性能风险和智能优化
> Compose:自动更新 -> 「更新范围过大、超过需求」 -> 「跳过没必要的更新」

