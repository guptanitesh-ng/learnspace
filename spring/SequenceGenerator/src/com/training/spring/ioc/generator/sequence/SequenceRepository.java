/**
 * 
 */
package com.training.spring.ioc.generator.sequence;

import org.springframework.scheduling.annotation.Async;

/**
 * @author nitesh
 *
 */
public interface SequenceRepository {

	@Async
	public void storeSequence(String sequenceValue);
}
