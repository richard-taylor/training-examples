# Software Design Exercise

The scenario for this exercise is that you have been asked to prepare for a
meeting with your Product Owner and a fellow Senior Software Engineer to
discuss the design and implementation of a particular component.

You have 20 minutes to study the material here. Then the meeting itself will
last approximately one hour.

## Scope

Look at the C4 System Context diagram. You are responsible for the design of
the *Pricing* software system. You are also responsible for collaborating with
the owners of the Reporting software system and the Cloud Platform software
system on the interfaces between the systems.

## Requirements

The primary requirement is that the *Pricing* system must be able to price all
the resource usage across _all_ the Cloud Platforms that the company operates.

Note that the C4 diagram shows a single Cloud Platform system. You should
consider the implications of having multiple _different_ Cloud Platform systems
to deal with at the same time.

## Starting Point

This is not a green field development. A prototype package already exists in
this project, along with two proposed interfaces.

Prototype package

 * com.ukcloud.pricing

Proposed interfaces

 * com.ukcloud.reporting
 * com.ukcloud.sources

You should be able to describe the structure of this existing code in the
meeting. You should also be able to explain where and why it is or is not
consistent with your proposed design.
