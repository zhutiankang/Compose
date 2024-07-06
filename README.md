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

**_通用的设置用 Modifier，专项的设置用函数参数_**
例如：clickable属于通用设置，so在 Modifier 中，除了Button有额外的 onClick参数，Button生来就是为了点击，主要是为了方便开发者，底部实现还是 Modifier

## 注意
> Compose padding 一鱼两吃
1. padding 与 margin 内边距与外边距是相对背景来说的，padding 包括背景，margin 不包括背景
2. Modifier.padding().background() -- 不包括背景 margin
3. Modifier.background().padding() -- 包括背景 padding
