package com.itcast.bean.product;

/**
 *
 * @author kang.cunhua
 */
import java.util.HashSet;
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

@Entity
public class ProductType {

  //类别id
  private Integer typeid;
  //类别名称
  private String name;
  //备注，用于google搜索页面描述
  private String note;
  //是否可见
  private Boolean visible = true;
  //子类别
  private Set<ProductType> childtypes = new HashSet<ProductType>();
  //所属父类
  private ProductType parent;

  public ProductType() {
  }

  public ProductType(Integer typeid) {
    this.typeid = typeid;
  }

  public ProductType(String name) {
    this.name = name;
  }

  public ProductType(String name, String note) {
    this.name = name;
    this.note = note;
  }

  /**
   * @return the typeid
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
  @Column(length = 36, nullable = false)
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
  @Column(length = 255)
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
  @Column(nullable = false)
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
  @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "parent")
//     @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "parent", fetch = FetchType.EAGER)
  public Set<ProductType> getChildtypes() {
    return childtypes;
  }

  /**
   * @param childtypes the childtypes to set
   */
  public void setChildtypes(Set<ProductType> childtypes) {
    this.childtypes = childtypes;
  }

  /**
   * @return the parent
   */
  // optional= false
  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "parentid")
  public ProductType getParent() {
    return parent;
  }

  /**
   * @param parent the parent to set
   */
  public void setParent(ProductType parent) {
    this.parent = parent;
  }
}
