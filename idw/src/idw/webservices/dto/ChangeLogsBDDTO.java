package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ChangeLogsBDDTO  implements Serializable {
    private List<ChangeLogBDDTO> changelog;

	public List<ChangeLogBDDTO> getChangelog() {
		return changelog;
	}

	public void setChangelog(List<ChangeLogBDDTO> changelog) {
		this.changelog = changelog;
	}

	
}