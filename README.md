# springstudy

利用spring底层组件开发（三层组件）：
    能够供我们使用的组件，都是Aware的子接口，即XXXAware
    以 ApplicationContextAware 为例: 实现步骤
        a.实现ApplicationContextAware
        b.重写其中的方法setApplicationContext，都包含了一个对象，只需将该对象复制到属性中即可（MyComponent.class）
        有什么用：例如ApplicationContextAware，可以通过该接口获取IOC的容器对象。
        执行时间：

        BeanNameAware:

--环境切换：
        @Profile
        spring：切换环境

        激活方式一:
            -Dspring.profiles.active=@Profile环境名
            用处：经常用到的比如数据库环境的切换设置
 
        激活方式二:
            硬编码
            错误写法：
            ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
                    environment.setActiveProfiles("myApple");
            原因：AnnotationConfigApplicationContext底层有refresh()操作,会将我们设置的一些参数给刷新还原了
            没激活  |-> 进行激活 -> 刷新
            解决方法：
                调整流程：
                    没激活 -> 进行激活   |-> 刷新
            什么时候设置保存点(|): 配置类的编写处
                    ApplicationContext context = new AnnotationConfigApplicationContext();
                            ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
                            environment.setActiveProfiles("myApple");
                            ((AnnotationConfigApplicationContext) context).register(MyConfig.class);
                            ((AnnotationConfigApplicationContext) context).refresh();
            IOC容器在使用时，必须refresh, 如果是有参构造则自动刷新，如果是无参构造则要手动刷新


Spring底层组件：
bean创建方式： 先声明bean  -》 解析（加载）bean --> 创建（实例化）bean --> DI（注入值）
        BeanPostProcessor 拦截容器之中的bean
        BeanFactoryPostProcessor： 拦截IOC容器
        BeanDefinitionRegistryPostProcessor：即将被加载之前（解析（加载）bean之前，称为beanDefinition对象之前）

        BeanDefinitionRegistryPostProcessor --> 加载bean --》 BeanFactoryPostProcessor --> 实例化bean  --》 BeanPostProcessor
        也可以在方法postProcessBeanDefinitionRegistry（）里手动注册一个bean：
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Orange.class);//产生BeanDefinition
        //        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        postProcessBeanDefinitionRegistry.registerBeanDefinition("myBean",beanDefinitionBuilder.getBeanDefinition());

监听器：
方式一: MyListener.class
1.实现ApplicationListener,可以监听事件
2.监听的对象必须是ApplicationEvent的子类或子接口
方式二: 注解 MyListener2.class
1.方法上加@EventListener(classes = {ApplicationEvent.class})
2.监听的对象可以是ApplicationEvent的子类或子接口，也可以是别的自定义的类，但是为了统一建议ApplicationEvent的子类或子接口
方式三:
自定义被监听事件 MyListener3.class
1.自定义类实现抽象类ApplicationEvent
2.发布自定义的事件 context.publishEvent(new ApplicationEvent("my Event")

Quartz: 定时任务
任务： 做什么事情
触发器：定义时间
调度器：将任务和触发器一一对应

--触发器 CronScheduleBuilder
Cron表达式：
6-7个参数，以空格隔开
秒   分   时   天(月份里的天)    月   天(星期里的天)     (年)
