package com.model;

import java.util.Set;

/**
 * <p>
 * GenericNestedResource class.
 * </p>
 *
 * @since 1.1.1
 */
public class GenericNestedResource {
	// lookup reference data id
	private Byte refDataId;

	private String otherValue;

	private String specifiedValue;

	private Set<GenericNestedResource> children;

	/**
	 * <p>
	 * Constructor for GenericNestedResource.
	 * </p>
	 *
	 * @since 1.1.2
	 */
	public GenericNestedResource() {
		super();
	}

	/**
	 * <p>
	 * Constructor for GenericNestedResource.
	 * </p>
	 *
	 * @param refDataId
	 *            a {@link java.lang.Byte} object.
	 * @since 1.1.2
	 */
	public GenericNestedResource(Byte refDataId) {
		this();
		this.refDataId = refDataId;
	}

	/**
	 * <p>
	 * Constructor for GenericNestedResource.
	 * </p>
	 *
	 * @param refDataId
	 *            a {@link java.lang.Byte} object.
	 * @param otherValue
	 *            a {@link java.lang.String} object.
	 * @since 1.1.2
	 */
	public GenericNestedResource(Byte refDataId, String otherValue) {
		this(refDataId);
		this.otherValue = otherValue;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * Getter for the field <code>refDataId</code>.
	 * </p>
	 * @since 1.1.1
	 */
	public Byte getRefDataId() {
		return refDataId;
	}

	/**
	 * <p>
	 * Setter for the field <code>refDataId</code>.
	 * </p>
	 *
	 * @param refDataId
	 *            a {@link java.lang.Byte} object.
	 * @since 1.1.1
	 */
	public void setRefDataId(Byte refDataId) {
		this.refDataId = refDataId;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * Getter for the field <code>otherValue</code>.
	 * </p>
	 * @since 1.1.1
	 */
	public String getOtherValue() {
		return otherValue;
	}

	/**
	 * <p>
	 * Setter for the field <code>otherValue</code>.
	 * </p>
	 *
	 * @param otherValue
	 *            a {@link java.lang.String} object.
	 * @since 1.1.1
	 */
	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * Getter for the field <code>specifiedValue</code>.
	 * </p>
	 * @since 1.1.1
	 */
	public String getSpecifiedValue() {
		return specifiedValue;
	}

	/**
	 * <p>
	 * Setter for the field <code>specifiedValue</code>.
	 * </p>
	 *
	 * @param specifiedValue
	 *            a {@link java.lang.String} object.
	 * @since 1.1.1
	 */
	public void setSpecifiedValue(String specifiedValue) {
		this.specifiedValue = specifiedValue;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * Getter for the field <code>children</code>.
	 * </p>
	 * @since 1.1.1
	 */
	public Set<GenericNestedResource> getChildren() {
		return children;
	}

	/**
	 * <p>
	 * Setter for the field <code>children</code>.
	 * </p>
	 *
	 * @param children
	 *            a {@link java.util.Set} object.
	 * @since 1.1.1
	 */
	public void setChildren(Set<GenericNestedResource> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return getRefDataId() + " : " + getSpecifiedValue() + " : " + getOtherValue() + " : " + ((null != getChildren()) ? getChildren().size() : 0);
	}
}
