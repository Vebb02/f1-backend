package no.vebb.f1.util.domainPrimitive;

import com.fasterxml.jackson.annotation.JsonValue;

import no.vebb.f1.database.Database;
import no.vebb.f1.util.exception.InvalidSessionTypeException;

public class SessionType {
	
	public final String value;
	private Database db;

	public SessionType(String value) {
		this.value = value;
	}

	public SessionType(String value, Database db) throws InvalidSessionTypeException {
		this.value = value;
		this.db = db;
		validate();
	}

	private void validate() throws InvalidSessionTypeException {
		if (!db.isValidSessionType(value)) {
			throw new InvalidSessionTypeException(String.format("'%s' is not at valid session type", value));
		}
	}

	@JsonValue
    public String toValue() {
        return value;
    }

	@Override
	public String toString() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionType other = (SessionType) obj;
		if (value == null) {
            return other.value == null;
		} else return value.equals(other.value);
    }

	
}
