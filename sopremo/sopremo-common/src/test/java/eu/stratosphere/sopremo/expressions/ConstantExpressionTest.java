package eu.stratosphere.sopremo.expressions;

import junit.framework.Assert;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.DoubleNode;
import org.codehaus.jackson.node.IntNode;
import org.junit.Ignore;
import org.junit.Test;

public class ConstantExpressionTest extends EvaluableExpressionTest<ConstantExpression> {

	@Override
	protected ConstantExpression createDefaultInstance(int index) {
		return new ConstantExpression(IntNode.valueOf(index));
	}

	@Override
	protected void initVerifier(EqualsVerifier<ConstantExpression> equalVerifier) {
		super.initVerifier(equalVerifier);
		equalVerifier.withPrefabValues(JsonNode.class, IntNode.valueOf(23), IntNode.valueOf(42));
		equalVerifier.suppress(Warning.TRANSIENT_FIELDS);
	}
	
	@Test
	public void shouldCastNumericNodeCorrectly() {
		final int result = new ConstantExpression(IntNode.valueOf(42)).asInt();

		Assert.assertEquals(42, result);
	}

	@Test
	public void should() {
		final int result = new ConstantExpression(DoubleNode.valueOf(42.0)).asInt();

		Assert.assertEquals(42, result);
	}

	@Test
	public void shouldReturnCorrectStringRepresentation() {
		final String result = new ConstantExpression(IntNode.valueOf(42)).asString();

		Assert.assertEquals("42", result);
	}
}
