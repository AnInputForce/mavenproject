package com.itcast.model.product;

/**
 * 产品类型
 * @author kang.cunhua
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 产品分类
 * @author Kang.Cunhua
 */
@Entity
@Table(name = "producttype") //指定表名为producttype
public class Type implements Serializable {

  //类别id
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer typeid;
  //类别名称
  @Column(length = 36, nullable = false)
  private String name;
  //备注，用于google搜索页面描述
  @Column(length = 255)
  private String note;
  //是否可见
  @Column(nullable = false)
  private Boolean visible = true;
  //子类别
  @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "parent")
  private Set<Type> childtypes = new HashSet<Type>();
  //所属父类
  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "parentid")
  private Type parent;
  @OneToMany(mappedBy = "type", cascade = CascadeType.REMOVE)
  private List<Infomation> infomations;

  /**
   *
   */
  public Type() {
  }

  /**
   *
   * @param typeid
   */
  public Type(Integer typeid) {
    this.typeid = typeid;
  }

  /**
   *
   * @param name
   */
  public Type(String name) {
    this.name = name;
  }

  /**
   *
   * @param name
   * @param note
   */
  public Type(String name, String note) {
    this.name = name;
    this.note = note;
  }

  /**
   * @return the typeid
   */
  public Integer getTypeid() {
    return typeid;
  }

  /**
   * @param typeid the typeid to set
   */
  public void setTypeid(Integer typeid) {
    this.typeid = typeid;
  }

  /**
   * @return the name
   */
  //使用Column来进行属性和数据库字段映射
  //默认属性和字段名字一致；
  //若不相同可采用name="***",来映射数据库中的xxx字段
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note the note to set
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * @return the visible
   */
  public Boolean getVisible() {
    return visible;
  }

  /**
   * @param visible the visible to set
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  /**
   * @return the childtypes
   */
  //定义一对多，级联刷新，级联删除，被维护端
  public Set<Type> getChildtypes() {
    return childtypes;
  }

  /**
   * @param childtypes the childtypes to set
   */
  public void setChildtypes(Set<Type> childtypes) {
    this.childtypes = childtypes;
  }

  /**
   * @return the parent
   */
  // optional= false
  public Type getParent() {
    return parent;
  }

  /**
   * @param parent the parent to set
   */
  public void setParent(Type parent) {
    this.parent = parent;
  }

  public List<Infomation> getInfomations() {
    return infomations;
  }

  public void setInfomations(List<Infomation> infomations) {
    this.infomations = infomations;
  }
}
