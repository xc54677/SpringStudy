package springDemo.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.*;
import springDemo.component.MyComponent;
import springDemo.component.MyXXX;
import springDemo.condition.EnergyCarCondition;
import springDemo.condition.OilCarCondition;
import springDemo.entity.*;

/**
 * componentScan只对三层对象负责，即 @Service，@Repository，@Controller
 */
@Configuration
//@ComponentScan(value="springDemo", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class, Repository.class})})
//@ComponentScan(value="springDemo", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class, Repository.class})}, useDefaultFilters = false)
//ASSIGNABLE_TYPE 对指定的类做过滤
//@ComponentScan(value="springDemo", includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {StudentController.class})}, useDefaultFilters = false)
//@ComponentScan(value="springDemo", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = {MyFilter.class})}, useDefaultFilters = false)
//@Import(value = {Apple.class,Banana.class}) 第一种直接import类名，
//@Import(value = {MyImportSelector.class}) //第二种实现ImportSelector
//@Import(value = {MyImportBeanDefinitionRegistrar.class}) //第二种实现ImportBeanDefinitionRegistrar
@ComponentScan(value="springDemo.component")
public class MyConfig {

	/*@Bean("stu")
	@Scope("singleton")//"prototype"
	@Lazy//使容器在单例模式时，初始初始化IOC容器时不创建这个bean，只在第一次使用时再创建，而且只创建这一次
	public Student student() {
		Student student = new Student(1, "zs", 20);
		student.setAdress(new Adress("Nanjing","Shanghai"));
		return student;
	}

	@Bean
	@Conditional(OilCarCondition.class)
	public Car oilCar(){
		return new OilCar();
	}

	@Bean
	@Conditional(EnergyCarCondition.class)
	public Car energyCar(){
		return new EnergyCar();
	}

	@Bean
	public FactoryBean<Apple> myFactoryBean(){
		return new MyFactoryBean();
	}*/

	/*@Profile("myApple")
	@Bean("apple")
	public Fruit apple(){
		return new Apple();
	}

	@Profile("myBanana")
	@Bean("banana")
	public Fruit banana(){
		return new Banana();
	}*/


}
