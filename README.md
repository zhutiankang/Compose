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

# MutableState 与 mutableStateOf()
> 刷新：组合（组合过程：拼凑出界面实际内容，官方表达Composition，先Compose，ComposeView,AndroidComposeView,LayoutNode,LayoutNode-LayoutNode）
> 布局
> 绘制

MutableState -> StateObject -> StateRecord -> Compose支持**事务**功能
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