package no.vebb.f1.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import no.vebb.f1.database.Database;
import no.vebb.f1.util.TimeUtil;

@Component
public class CodeRemover {

	private final Database db;

	public CodeRemover(Database db) {
		this.db = db;
	}


	@Scheduled(fixedDelay = TimeUtil.FIVE_MINUTES, initialDelay = TimeUtil.HALF_MINUTE)
	public void removeExpiredCodes() {
		db.removeExpiredVerificationCodes();
		db.removeExpiredReferralCodes();
	}
}
