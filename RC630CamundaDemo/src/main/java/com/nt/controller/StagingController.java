package com.nt.controller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.entity.Client;
import com.nt.entity.InterView;
import com.nt.service.IClientService;


@Controller("staging")
public class StagingController implements JavaDelegate {
	public int round=1;
	public boolean isInsert=false;
	@Autowired
	private IClientService service;
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String interviewhanges=(String) execution.getVariable("interviewhanges");
		String interviewerName=(String) execution.getVariable("interviewername");
		Integer interviewNo=(Integer) execution.getVariable("interview");//2
		Integer interviewRound=(Integer) execution.getVariable("interviewNumber");
		//Integer interviewNumber=(Integer) execution.getVariable("interviewNumber");
		String no_of_interviewers=(String) execution.getVariable("no_of_interviewers");

		String percentage=(String) execution.getVariable("percentage");
		String day=(String) execution.getVariable("day");
		String profile=(String) execution.getVariable("profile");
		String experience=(String) execution.getVariable("experience");
		execution.setVariable("result", 1);
		Integer result=(Integer)execution.getVariable("result");

		String checkbox1=(String)execution.getVariable("checkbox1");
		String checkbox2=(String)execution.getVariable("checkbox2");
		String checkbox3=(String)execution.getVariable("checkbox3");
		
		
		
		//----------new ----------------------

		String companyname=(String) execution.getVariable("companyname");
		String clientname=(String)execution.getVariable("clientname");
		String clientemail=(String)execution.getVariable("clientemail");
		//--------------------------------------------------------
		String nameOfTheInterviewer=null;
		if(checkbox1!=null&&checkbox2!=null&&checkbox3!=null) {
			nameOfTheInterviewer= checkbox1+", "+checkbox2+" , "+checkbox3;
		}else if((checkbox1!=null&&checkbox2!=null )) {
			nameOfTheInterviewer= checkbox1+", "+checkbox2;
		}else if((checkbox2!=null&&checkbox3!=null )) {
			nameOfTheInterviewer= checkbox2+", "+checkbox3;
		}else if((checkbox3!=null&&checkbox1!=null )) {
			nameOfTheInterviewer= checkbox3+", "+checkbox1;
		}

		else if((checkbox1!=null)) {
			nameOfTheInterviewer= checkbox1;
		}else if((checkbox2!=null)) {
			nameOfTheInterviewer= checkbox2;
		}else if((checkbox3!=null)) {
			nameOfTheInterviewer= checkbox3;
		}
		


		else {
			System.out.println("no check box are selected ");
		}

	//	System.out.println(checkbox1+"============"+checkbox3+"======================check========="+checkbox2);



		Client client=new Client();
		InterView view=new InterView();

		view.setInterviewNo(interviewNo);
		if(interviewhanges!=null)
			view.setInterviewhanges(interviewhanges);
		else
			view.setInterviewhanges("no");
		view.setNameOfTheInterviewer(nameOfTheInterviewer);
		view.setNo_of_interviewers(no_of_interviewers);
		client.setPercentage(percentage);

		view.setFirstInterviewerName(interviewerName);
		view.setFirstInterviewRound(interviewRound);
		view.setFirstInterviewDate(day);


		client.setDay(day);


		client.setProfile(profile);
		client.setExperience(experience);
		client.setView(view);


		if(interviewNo==interviewRound) {
			view.setSecoundInterviewerName(interviewerName);
			view.setSecoundInterviewRound(interviewRound);
			view.setSecoundInterviewDate(day);



			client.setView(view);

			round=1;
			execution.setVariable("result", 0);
			Client data= service.insertRecored(client);
			if(data!=null) {
				System.out.println("recored update");

			}else {
				System.out.println("recored not inserted ");
			}


		}else {
			execution.setVariable("result", 1);
			if(round==1) {
				view.setFirstInterviewerName(interviewerName);
				view.setFirstInterviewRound(interviewRound);
				view.setFirstInterviewDate(day);
				client.setView(view);
				Client data= service.insertRecored(client);
				if(data!=null) {
					System.out.println("recored inserted\n\n");
					client.setId(data.getId());
				}else {
					System.out.println("recored not inserted ");
				}

			}
			round++;
			isInsert=true;
		}




	} 


	@GetMapping("/round")
	@ResponseBody
	public int getData() {
		return round;
	}



}
