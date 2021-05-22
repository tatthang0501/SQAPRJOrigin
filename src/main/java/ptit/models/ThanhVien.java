package ptit.models;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "thanhvien", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
@Data
public class ThanhVien {
	public ThanhVien() {
	}

	public ThanhVien(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "ngaysinh")
	private String ngaySinh;


	@Column(name = "email")
	private String email;

	@Column(name = "dt")
	private String dt;

	@Column(name = "ghichu")
	private String ghichu;

	@Column(name = "vitri")
	private String vitri;

	@Column(name = "ho")
	private String ho;

	@Column(name = "dem")
	private String dem;

	@Column(name = "ten")
	private String ten;

	@OneToOne
	@JoinColumn(name = "diachiid", referencedColumnName = "id")
	private DiaChi diaChi;
}
