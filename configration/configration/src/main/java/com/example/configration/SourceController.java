package com.example.configration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class SourceController {

	// s@Autowired
	private MyBean myBean;
	private MySpec mySpeac;

	public SourceController(MyBean myBean, MySpec mySpeac) {

		this.myBean = myBean;
		this.mySpeac = mySpeac;
	}

	@GetMapping("/bean")
	public String getBean() {

		return myBean.getMyLong() + " " + myBean.getMyDouble() + " " + myBean.getMyString() + " "
				+ myBean.getClass().getName();
	}

	@GetMapping("/speac")
	public String getSpeac() {

		return mySpeac.myMethode("  girdi")+""+mySpeac.getClass().getName();
	}

}
