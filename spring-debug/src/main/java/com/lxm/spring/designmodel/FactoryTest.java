package com.lxm.spring.designmodel;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/16 20:12
 * @Version 1.0
 */
public class FactoryTest {
	public static void main(String[] args) {
		Kitchen kitchen = new KitchenFactory();
		KitchenMeal meal = kitchen.getMeal("p.1");
		String name = meal.getName();
		System.out.println("the factory create product is ###--->:" + name);


	}

}


/**
 * 抽象工厂
 */
abstract class Kitchen {
	/**
	 * 肉类
	 *
	 * @param preferency
	 * @return
	 */
	public abstract KitchenMeal getMeal(String preferency);

	/**
	 * 点心
	 *
	 * @param preferency
	 * @return
	 */
	public abstract KitchenMeal getDessert(String preferency);
}

/**
 * 具体工厂的实现
 */
class KitchenFactory extends Kitchen {


	/**
	 * 肉类
	 *
	 * @return
	 */
	@Override
	public KitchenMeal getMeal(String preferency) {
		if ("P.1".equals(preferency)) {
			return new ProteinMeal();
		} else if ("F.1".equals(preferency)) {
			return new FastFoodMeal();
		}
		return new VegetarianMeal();
	}

	/**
	 * 点心
	 *
	 * @return
	 */
	@Override
	public KitchenMeal getDessert(String preferency) {
		if ("I.1".equals(preferency)) {
			return new IceCreamMeal();
		}
		return null;
	}
}

/**
 * 抽象的产品
 */
abstract class KitchenMeal {
	/**
	 * 根据名称获取产品
	 *
	 * @return
	 */
	public abstract String getName();
}

/**
 * 具体产品的实现
 */
class ProteinMeal extends KitchenMeal {
	/**
	 * 根据名称获取产品
	 *
	 * @return
	 */
	@Override
	public String getName() {
		return "protein meal";
	}
}


class VegetarianMeal extends KitchenMeal {
	@Override
	public String getName() {
		return "vegetarian meal";
	}
}

class FastFoodMeal extends KitchenMeal {
	@Override
	public String getName() {
		return "fast-food meal";
	}
}

class IceCreamMeal extends KitchenMeal {
	@Override
	public String getName() {
		return "ice-cream";
	}
}
