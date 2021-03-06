package com.kyj.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fileinfo")
public class FileInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 200)
	private String name;
	
	private long size;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private java.util.Calendar createDate;
	
	@Size(max = 200)
	private String path;
	
	@Length(max = 5)
	private String extension;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "structure_id", nullable = false)
	private Structure structure;

	@JsonIgnore
	@OneToMany(mappedBy = "fileInfo", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
	private List<ExternalFile> externalFiles = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public java.util.Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Calendar createDate) {
		this.createDate = createDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public List<ExternalFile> getExternalFiles() {
		return externalFiles;
	}

	public void setExternalFiles(List<ExternalFile> externalFiles) {
		this.externalFiles = externalFiles;
	}	
	
}
