package test;

import configuration.DataBaseConfiguration;
import configuration.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import station.dao.PompeDao;
import station.dto.PompeDto;
import station.entity.Cuve;
import station.entity.Pompe;
import station.service.CuveService;
import station.service.PompeService;

import java.util.Arrays;


public class Test {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.register(SpringConfig.class);
	ctx.refresh();
//		System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
//
		PompeService pompeSer=(PompeService) ctx.getBean("defaultPompeService");
	CuveService cuveService=(CuveService) ctx.getBean("defaultCuveService");
	PompeDto pome= new PompeDto();
		pome.setId("1");
		pome.setIndex("1523");
		pompeSer.create(pome);
//		Pompe pome2= new Pomp();
//		pome2.setId(2);
//		pome2.setIndex(1523);
//		pompeSer.create(pome2);
//		Cuve cuve=new Cuve();
//		cuve.setId(1);
//		cuve.setCapacite(1500);
//		cuveService.create(cuve);
//		pompeSer.connectPompeToCuve(pome,cuve);
//		pompeSer.connectPompeToCuve(pome2,cuve);
//
//		System.out.println(pompeSer.calculateRendement(1,1726));
		//pompeSer.updateIndex(1,1856);
		//pompeSer.deconnectPompeToCuve(1,1);
		//cuveService.consulterRest(1);


	}

}
