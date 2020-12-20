package com.tts.eCommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tts.eCommerce.Service.StripeService;
import com.tts.eCommerce.model.ChargeRequest;
import com.tts.eCommerce.model.ChargeRequest.Currency;


@Controller
public class ChargeController {

	@Autowired
	private StripeService paymentsService;

	@PostMapping("/charge")
	public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {

		chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.EUR);
		Charge charge = paymentsService.charge(chargeRequest);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		model.addAttribute("chargeId", charge.getId());
		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";  
}

	public Object getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStripeToken() {
		// TODO Auto-generated method stub
		return null;
	}
}	
