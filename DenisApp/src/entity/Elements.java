package entity;

public class Elements {
	
	private int id;
	private String materialName;
	private Double c;
	private Double mn;
	private Double cr;
	private Double mo;
	private Double v;
	private Double ni;
	private Double cu;
	private Double si;
	private Double b;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Double getC() {
		return c;
	}
	@Override
	public String toString() {
		return "Elements [id=" + id + ", materialName=" + materialName + ", c=" + c + ", mn=" + mn + ", cr=" + cr
				+ ", mo=" + mo + ", v=" + v + ", ni=" + ni + ", cu=" + cu + ", si=" + si + ", b=" + b + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((cr == null) ? 0 : cr.hashCode());
		result = prime * result + ((cu == null) ? 0 : cu.hashCode());
		result = prime * result + id;
		result = prime * result + ((materialName == null) ? 0 : materialName.hashCode());
		result = prime * result + ((mn == null) ? 0 : mn.hashCode());
		result = prime * result + ((mo == null) ? 0 : mo.hashCode());
		result = prime * result + ((ni == null) ? 0 : ni.hashCode());
		result = prime * result + ((si == null) ? 0 : si.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
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
		Elements other = (Elements) obj;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (cr == null) {
			if (other.cr != null)
				return false;
		} else if (!cr.equals(other.cr))
			return false;
		if (cu == null) {
			if (other.cu != null)
				return false;
		} else if (!cu.equals(other.cu))
			return false;
		if (id != other.id)
			return false;
		if (materialName == null) {
			if (other.materialName != null)
				return false;
		} else if (!materialName.equals(other.materialName))
			return false;
		if (mn == null) {
			if (other.mn != null)
				return false;
		} else if (!mn.equals(other.mn))
			return false;
		if (mo == null) {
			if (other.mo != null)
				return false;
		} else if (!mo.equals(other.mo))
			return false;
		if (ni == null) {
			if (other.ni != null)
				return false;
		} else if (!ni.equals(other.ni))
			return false;
		if (si == null) {
			if (other.si != null)
				return false;
		} else if (!si.equals(other.si))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
	public void setC(Double c) {
		this.c = c;
	}
	public Double getMn() {
		return mn;
	}
	public void setMn(Double mn) {
		this.mn = mn;
	}
	public Double getCr() {
		return cr;
	}
	public void setCr(Double cr) {
		this.cr = cr;
	}
	public Double getMo() {
		return mo;
	}
	public void setMo(Double mo) {
		this.mo = mo;
	}
	public Double getV() {
		return v;
	}
	public void setV(Double v) {
		this.v = v;
	}
	public Double getNi() {
		return ni;
	}
	public void setNi(Double ni) {
		this.ni = ni;
	}
	public Double getCu() {
		return cu;
	}
	public void setCu(Double cu) {
		this.cu = cu;
	}
	public Double getSi() {
		return si;
	}
	public void setSi(Double si) {
		this.si = si;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
}
