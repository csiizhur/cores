package com.lanen.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 个体猴子集体
 * @author Administrator
 *
 */
public class Individual_Json implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8921843795863991106L;
	
	private Integer id; //主键
    private String monkeyid; //猴子id XXXXXX（两位年两位月三位流水号）
    private Integer animaltype;//猴子种类 要新建库
    private String birthday; //生日
    private String frid;//(空)
    private Integer agetype;//年龄类型  1 仔猴  2 育成猴  3 成年猴
    private Byte iszhongqun; //种群
    private Byte sex;//性别 0 公 1 母 
    private Integer source;//录入人
    private Byte generation;//代数 12345
    private String leavebreastdate;//离乳日期
    private Float currentweight;//目前的体重
    private Float birthdayweight;//出生体重
    private Float leavebreastweight;//离乳体重
    private String fatherid;//父亲编号。母亲往前推10个月所在的笼子的公猴
    private String motherid;//母亲
    private Integer blongarea;//区域
    private String quyu;//
    private Integer dong;//(null)
    private Integer room;//房间
    private String roomName; //房间名
    private Integer keeper;//饲养员
    private String  keeperp;
    private Integer veterinarian;//兽医
    private Integer operater;//操作员（null）
    private String operaterr;
    private Byte deleted;//删除
	private Integer modified_by;//修改者
	private Date createtime;//创建时间
    private Integer created_by;//创建人
	private Date lastmodifytime;//最后修改时间
	private String tnid;  //体内编号
	private String ysz;//运输证
    private String yjdate;//运进时间
    private String sourceaddress;//源地址（NULL）
    private String yjaddress;//运进地址
    private String remark;//备注
    private Integer status;//
    private String lhao;//
    private String currentdate;//现在日期 存在null 
    private String image;//图片
    private Date  weighingDate;//称重日期
    
    private String animaltypeName;
    private String chipid;
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public String getKeeperp() {
		return keeperp;
	}
	public void setKeeperp(String keeperp) {
		this.keeperp = keeperp;
	}
	public Date getWeighingDate() {
		return weighingDate;
	}
	public void setWeighingDate(Date weighingDate) {
		this.weighingDate = weighingDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMonkeyid() {
		return monkeyid;
	}
	public void setMonkeyid(String monkeyid) {
		this.monkeyid = monkeyid;
	}
	public Integer getAnimaltype() {
		return animaltype;
	}
	public void setAnimaltype(Integer animaltype) {
		this.animaltype = animaltype;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getFrid() {
		return frid;
	}
	public void setFrid(String frid) {
		this.frid = frid;
	}
	public Integer getAgetype() {
		return agetype;
	}
	public void setAgetype(Integer agetype) {
		this.agetype = agetype;
	}
	
	
	public Byte getIszhongqun() {
		return iszhongqun;
	}
	public void setIszhongqun(Byte iszhongqun) {
		this.iszhongqun = iszhongqun;
	}
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	
	public Byte getGeneration() {
		return generation;
	}
	public void setGeneration(Byte generation) {
		this.generation = generation;
	}
	public String getLeavebreastdate() {
		return leavebreastdate;
	}
	public void setLeavebreastdate(String leavebreastdate) {
		this.leavebreastdate = leavebreastdate;
	}
	public String getFatherid() {
		return fatherid;
	}
	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}
	public String getMotherid() {
		return motherid;
	}
	public void setMotherid(String motherid) {
		this.motherid = motherid;
	}
	public Integer getBlongarea() {
		return blongarea;
	}
	public void setBlongarea(Integer blongarea) {
		this.blongarea = blongarea;
	}
	public Integer getDong() {
		return dong;
	}
	public void setDong(Integer dong) {
		this.dong = dong;
	}
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
	public Integer getKeeper() {
		return keeper;
	}
	public void setKeeper(Integer keeper) {
		this.keeper = keeper;
	}
	public Integer getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(Integer veterinarian) {
		this.veterinarian = veterinarian;
	}
	public Integer getOperater() {
		return operater;
	}
	public void setOperater(Integer operater) {
		this.operater = operater;
	}
	public Integer getModified_by() {
		return modified_by;
	}
	public void setModified_by(Integer modifiedBy) {
		modified_by = modifiedBy;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer createdBy) {
		created_by = createdBy;
	}
	public Date getLastmodifytime() {
		return lastmodifytime;
	}
	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}
	public String getTnid() {
		return tnid;
	}
	public void setTnid(String tnid) {
		this.tnid = tnid;
	}
	public String getYsz() {
		return ysz;
	}
	public void setYsz(String ysz) {
		this.ysz = ysz;
	}
	public String getYjdate() {
		return yjdate;
	}
	public void setYjdate(String yjdate) {
		this.yjdate = yjdate;
	}
	public String getSourceaddress() {
		return sourceaddress;
	}
	public void setSourceaddress(String sourceaddress) {
		this.sourceaddress = sourceaddress;
	}
	public String getYjaddress() {
		return yjaddress;
	}
	public void setYjaddress(String yjaddress) {
		this.yjaddress = yjaddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLhao() {
		return lhao;
	}
	public void setLhao(String lhao) {
		this.lhao = lhao;
	}
	public String getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Float getLeavebreastweight() {
		return leavebreastweight;
	}
	public void setLeavebreastweight(Float leavebreastweight) {
		this.leavebreastweight = leavebreastweight;
	}
	public Float getCurrentweight() {
		return currentweight;
	}
	public void setCurrentweight(Float currentweight) {
		this.currentweight = currentweight;
	}
	public Float getBirthdayweight() {
		return birthdayweight;
	}
	public void setBirthdayweight(Float birthdayweight) {
		this.birthdayweight = birthdayweight;
	}
	public Byte getDeleted() {
		return deleted;
	}
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getOperaterr() {
		return operaterr;
	}
	public void setOperaterr(String operaterr) {
		this.operaterr = operaterr;
	}
	public String getAnimaltypeName() {
		return animaltypeName;
	}
	public void setAnimaltypeName(String animaltypeName) {
		this.animaltypeName = animaltypeName;
	}
	public String getChipid() {
		return chipid;
	}
	public void setChipid(String chipid) {
		this.chipid = chipid;
	}
	
    
    

}
