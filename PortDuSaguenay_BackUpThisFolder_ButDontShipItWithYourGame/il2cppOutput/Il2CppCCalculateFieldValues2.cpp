#include "pch-cpp.hpp"

#ifndef _MSC_VER
# include <alloca.h>
#else
# include <malloc.h>
#endif


#include <stdint.h>
#include <limits>



// System.Action`1<System.Boolean>
struct Action_1_t10DCB0C07D0D3C565CEACADC80D1152B35A45F6C;
// System.Action`1<UnityEngineInternal.Input.NativeInputUpdateType>
struct Action_1_t7797D4D8783204B10C3D28B96B049C48276C3B1B;
// System.Action`1<System.String>
struct Action_1_t3CB5D1A819C3ED3F99E9E39F890F18633253949A;
// System.Action`2<System.Int32,System.String>
struct Action_2_t6AAF2E215E74E16A4EEF0A0749A4A325D99F5BA6;
// System.Action`3<System.Boolean,System.Boolean,System.Int32>
struct Action_3_t4730167C8E7EB19F1E0034580790A915D549F6CB;
// System.Collections.Generic.Dictionary`2<System.String,UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/AfterFunctionDelegate>
struct Dictionary_2_t07B33916E5B9BFBEDDE5C206E597C4A2071ED5E6;
// System.Collections.Generic.Dictionary`2<System.String,UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/BeforeFunctionDelegate>
struct Dictionary_2_tE800B4C2237603A792FFCCFB9BFC21EA79CB7F3F;
// System.Func`2<UnityEngineInternal.Input.NativeInputUpdateType,System.Boolean>
struct Func_2_t880CA675AE5D39E081BEEF14DC092D82674DE4F2;
// System.Collections.Generic.List`1<System.String>
struct List_1_tF470A3BE5C1B5B68E1325EF3F109D172E60BD7CD;
// System.Collections.Generic.List`1<UnityEngine.XR.XRNodeState>
struct List_1_t8AE5A65CCFBC753343962D38B82C801F7BDE3C87;
// System.Collections.Generic.List`1<UnityEngine.SpatialTracking.TrackedPoseDriver/TrackedPose>
struct List_1_t8A06DB5554CD76CE072807DE6EF4198109D84E53;
// System.Collections.Generic.List`1<UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData>
struct List_1_tA8C10B8A593896280D68A4B006217C43F236DE0D;
// System.Action
struct Action_tD00B0A84D7945E50C2DFFC28EFEE6ED44ED2AD07;
// UnityEngine.Experimental.XR.Interaction.BasePoseProvider
struct BasePoseProvider_t55E2883DF2C8052200284D64B68471636876FA1D;
// UnityEngineInternal.Input.NativeUpdateCallback
struct NativeUpdateCallback_tC5CA5A9117B79251968A4DA3758552EFE1D37495;
// System.String
struct String_t;
// System.Void
struct Void_t4861ACF8F4594C3437BB48B6E56783494B843915;
// UnityEngine.Analytics.AnalyticsSessionInfo/IdentityTokenChanged
struct IdentityTokenChanged_tE8CB0DAB5F6E640A847803F582E6CB6237742395;
// UnityEngine.Analytics.AnalyticsSessionInfo/SessionStateChanged
struct SessionStateChanged_t1180FB66E702B635CAD9316DC661D931277B2A0C;
// UnityEngine.Experimental.Audio.AudioSampleProvider/SampleFramesHandler
struct SampleFramesHandler_tFE84FF9BBCEFB880D46227188F375BEF680AAA30;
// UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/ScriptEventDelegate
struct ScriptEventDelegate_t0DE50F0234F04B68173703087BFCB08BB4922E20;
// UnityEngine.RemoteSettings/UpdatedEventHandler
struct UpdatedEventHandler_tB0D5A5BA322FE093894992C29DCF51E7E12579C4;



IL2CPP_EXTERN_C_BEGIN
IL2CPP_EXTERN_C_END

#ifdef __clang__
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Winvalid-offsetof"
#pragma clang diagnostic ignored "-Wunused-variable"
#endif

// UnityEngine.Analytics.AnalyticsSessionInfo
struct AnalyticsSessionInfo_tDE8F7A9E13EF9723E2D975F76E916753DA61AD76  : public RuntimeObject
{
};

struct AnalyticsSessionInfo_tDE8F7A9E13EF9723E2D975F76E916753DA61AD76_StaticFields
{
	// UnityEngine.Analytics.AnalyticsSessionInfo/SessionStateChanged UnityEngine.Analytics.AnalyticsSessionInfo::sessionStateChanged
	SessionStateChanged_t1180FB66E702B635CAD9316DC661D931277B2A0C* ___sessionStateChanged_0;
	// UnityEngine.Analytics.AnalyticsSessionInfo/IdentityTokenChanged UnityEngine.Analytics.AnalyticsSessionInfo::identityTokenChanged
	IdentityTokenChanged_tE8CB0DAB5F6E640A847803F582E6CB6237742395* ___identityTokenChanged_1;
};

// UnityEngine.Experimental.Audio.AudioSampleProvider
struct AudioSampleProvider_t602353124A2F6F2AEC38E56C3C21932344F712E2  : public RuntimeObject
{
	// UnityEngine.Experimental.Audio.AudioSampleProvider/SampleFramesHandler UnityEngine.Experimental.Audio.AudioSampleProvider::sampleFramesAvailable
	SampleFramesHandler_tFE84FF9BBCEFB880D46227188F375BEF680AAA30* ___sampleFramesAvailable_0;
	// UnityEngine.Experimental.Audio.AudioSampleProvider/SampleFramesHandler UnityEngine.Experimental.Audio.AudioSampleProvider::sampleFramesOverflow
	SampleFramesHandler_tFE84FF9BBCEFB880D46227188F375BEF680AAA30* ___sampleFramesOverflow_1;
};

// UnityEngineInternal.Input.NativeInputSystem
struct NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE  : public RuntimeObject
{
};

struct NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE_StaticFields
{
	// UnityEngineInternal.Input.NativeUpdateCallback UnityEngineInternal.Input.NativeInputSystem::onUpdate
	NativeUpdateCallback_tC5CA5A9117B79251968A4DA3758552EFE1D37495* ___onUpdate_0;
	// System.Action`1<UnityEngineInternal.Input.NativeInputUpdateType> UnityEngineInternal.Input.NativeInputSystem::onBeforeUpdate
	Action_1_t7797D4D8783204B10C3D28B96B049C48276C3B1B* ___onBeforeUpdate_1;
	// System.Func`2<UnityEngineInternal.Input.NativeInputUpdateType,System.Boolean> UnityEngineInternal.Input.NativeInputSystem::onShouldRunUpdate
	Func_2_t880CA675AE5D39E081BEEF14DC092D82674DE4F2* ___onShouldRunUpdate_2;
	// System.Action`2<System.Int32,System.String> UnityEngineInternal.Input.NativeInputSystem::s_OnDeviceDiscoveredCallback
	Action_2_t6AAF2E215E74E16A4EEF0A0749A4A325D99F5BA6* ___s_OnDeviceDiscoveredCallback_3;
};

// UnityEngine.SpatialTracking.PoseDataSource
struct PoseDataSource_tF08072CF4DBA9641E6AE6D1DBA1D421DA9C46858  : public RuntimeObject
{
};

struct PoseDataSource_tF08072CF4DBA9641E6AE6D1DBA1D421DA9C46858_StaticFields
{
	// System.Collections.Generic.List`1<UnityEngine.XR.XRNodeState> UnityEngine.SpatialTracking.PoseDataSource::nodeStates
	List_1_t8AE5A65CCFBC753343962D38B82C801F7BDE3C87* ___nodeStates_0;
};

// UnityEngine.RemoteSettings
struct RemoteSettings_t9DFFC747AB3E7A39DF4527F245B529A407427250  : public RuntimeObject
{
};

struct RemoteSettings_t9DFFC747AB3E7A39DF4527F245B529A407427250_StaticFields
{
	// UnityEngine.RemoteSettings/UpdatedEventHandler UnityEngine.RemoteSettings::Updated
	UpdatedEventHandler_tB0D5A5BA322FE093894992C29DCF51E7E12579C4* ___Updated_0;
	// System.Action UnityEngine.RemoteSettings::BeforeFetchFromServer
	Action_tD00B0A84D7945E50C2DFFC28EFEE6ED44ED2AD07* ___BeforeFetchFromServer_1;
	// System.Action`3<System.Boolean,System.Boolean,System.Int32> UnityEngine.RemoteSettings::Completed
	Action_3_t4730167C8E7EB19F1E0034580790A915D549F6CB* ___Completed_2;
};

// UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription
struct TrackedPoseDriverDataDescription_tDD80D37EB4F938007BCE0FAB9705032594E4D9FF  : public RuntimeObject
{
};

struct TrackedPoseDriverDataDescription_tDD80D37EB4F938007BCE0FAB9705032594E4D9FF_StaticFields
{
	// System.Collections.Generic.List`1<UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData> UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription::DeviceData
	List_1_tA8C10B8A593896280D68A4B006217C43F236DE0D* ___DeviceData_0;
};

// System.ValueType
struct ValueType_t6D9B272BD21782F0A9A14F2E41F85A50E97A986F  : public RuntimeObject
{
};
// Native definition for P/Invoke marshalling of System.ValueType
struct ValueType_t6D9B272BD21782F0A9A14F2E41F85A50E97A986F_marshaled_pinvoke
{
};
// Native definition for COM marshalling of System.ValueType
struct ValueType_t6D9B272BD21782F0A9A14F2E41F85A50E97A986F_marshaled_com
{
};

// UnityEngine.XR.XRDevice
struct XRDevice_tD076A68EFE413B3EEEEA362BE0364A488B58F194  : public RuntimeObject
{
};

struct XRDevice_tD076A68EFE413B3EEEEA362BE0364A488B58F194_StaticFields
{
	// System.Action`1<System.String> UnityEngine.XR.XRDevice::deviceLoaded
	Action_1_t3CB5D1A819C3ED3F99E9E39F890F18633253949A* ___deviceLoaded_0;
};

// System.Guid
struct Guid_t 
{
	// System.Int32 System.Guid::_a
	int32_t ____a_1;
	// System.Int16 System.Guid::_b
	int16_t ____b_2;
	// System.Int16 System.Guid::_c
	int16_t ____c_3;
	// System.Byte System.Guid::_d
	uint8_t ____d_4;
	// System.Byte System.Guid::_e
	uint8_t ____e_5;
	// System.Byte System.Guid::_f
	uint8_t ____f_6;
	// System.Byte System.Guid::_g
	uint8_t ____g_7;
	// System.Byte System.Guid::_h
	uint8_t ____h_8;
	// System.Byte System.Guid::_i
	uint8_t ____i_9;
	// System.Byte System.Guid::_j
	uint8_t ____j_10;
	// System.Byte System.Guid::_k
	uint8_t ____k_11;
};

struct Guid_t_StaticFields
{
	// System.Guid System.Guid::Empty
	Guid_t ___Empty_0;
};

// System.IntPtr
struct IntPtr_t 
{
	// System.Void* System.IntPtr::m_value
	void* ___m_value_0;
};

struct IntPtr_t_StaticFields
{
	// System.IntPtr System.IntPtr::Zero
	intptr_t ___Zero_1;
};

// UnityEngineInternal.Input.NativeInputEvent
struct NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8 
{
	union
	{
		struct
		{
			union
			{
				#pragma pack(push, tp, 1)
				struct
				{
					// UnityEngineInternal.Input.NativeInputEventType UnityEngineInternal.Input.NativeInputEvent::type
					int32_t ___type_1;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					int32_t ___type_1_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___sizeInBytes_2_OffsetPadding[4];
					// System.UInt16 UnityEngineInternal.Input.NativeInputEvent::sizeInBytes
					uint16_t ___sizeInBytes_2;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___sizeInBytes_2_OffsetPadding_forAlignmentOnly[4];
					uint16_t ___sizeInBytes_2_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___deviceId_3_OffsetPadding[6];
					// System.UInt16 UnityEngineInternal.Input.NativeInputEvent::deviceId
					uint16_t ___deviceId_3;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___deviceId_3_OffsetPadding_forAlignmentOnly[6];
					uint16_t ___deviceId_3_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___time_4_OffsetPadding[8];
					// System.Double UnityEngineInternal.Input.NativeInputEvent::time
					double ___time_4;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___time_4_OffsetPadding_forAlignmentOnly[8];
					double ___time_4_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___eventId_5_OffsetPadding[16];
					// System.Int32 UnityEngineInternal.Input.NativeInputEvent::eventId
					int32_t ___eventId_5;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___eventId_5_OffsetPadding_forAlignmentOnly[16];
					int32_t ___eventId_5_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
			};
		};
		uint8_t NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8__padding[20];
	};
};

// UnityEngineInternal.Input.NativeInputEventBuffer
struct NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD 
{
	union
	{
		struct
		{
			union
			{
				#pragma pack(push, tp, 1)
				struct
				{
					// System.Void* UnityEngineInternal.Input.NativeInputEventBuffer::eventBuffer
					void* ___eventBuffer_0;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					void* ___eventBuffer_0_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___eventCount_1_OffsetPadding[8];
					// System.Int32 UnityEngineInternal.Input.NativeInputEventBuffer::eventCount
					int32_t ___eventCount_1;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___eventCount_1_OffsetPadding_forAlignmentOnly[8];
					int32_t ___eventCount_1_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___sizeInBytes_2_OffsetPadding[12];
					// System.Int32 UnityEngineInternal.Input.NativeInputEventBuffer::sizeInBytes
					int32_t ___sizeInBytes_2;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___sizeInBytes_2_OffsetPadding_forAlignmentOnly[12];
					int32_t ___sizeInBytes_2_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___capacityInBytes_3_OffsetPadding[16];
					// System.Int32 UnityEngineInternal.Input.NativeInputEventBuffer::capacityInBytes
					int32_t ___capacityInBytes_3;
				};
				#pragma pack(pop, tp)
				#pragma pack(push, tp, 1)
				struct
				{
					char ___capacityInBytes_3_OffsetPadding_forAlignmentOnly[16];
					int32_t ___capacityInBytes_3_forAlignmentOnly;
				};
				#pragma pack(pop, tp)
			};
		};
		uint8_t NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD__padding[20];
	};
};

// UnityEngine.Quaternion
struct Quaternion_tDA59F214EF07D7700B26E40E562F267AF7306974 
{
	// System.Single UnityEngine.Quaternion::x
	float ___x_0;
	// System.Single UnityEngine.Quaternion::y
	float ___y_1;
	// System.Single UnityEngine.Quaternion::z
	float ___z_2;
	// System.Single UnityEngine.Quaternion::w
	float ___w_3;
};

struct Quaternion_tDA59F214EF07D7700B26E40E562F267AF7306974_StaticFields
{
	// UnityEngine.Quaternion UnityEngine.Quaternion::identityQuaternion
	Quaternion_tDA59F214EF07D7700B26E40E562F267AF7306974 ___identityQuaternion_4;
};

// UnityEngine.Vector3
struct Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 
{
	// System.Single UnityEngine.Vector3::x
	float ___x_2;
	// System.Single UnityEngine.Vector3::y
	float ___y_3;
	// System.Single UnityEngine.Vector3::z
	float ___z_4;
};

struct Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2_StaticFields
{
	// UnityEngine.Vector3 UnityEngine.Vector3::zeroVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___zeroVector_5;
	// UnityEngine.Vector3 UnityEngine.Vector3::oneVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___oneVector_6;
	// UnityEngine.Vector3 UnityEngine.Vector3::upVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___upVector_7;
	// UnityEngine.Vector3 UnityEngine.Vector3::downVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___downVector_8;
	// UnityEngine.Vector3 UnityEngine.Vector3::leftVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___leftVector_9;
	// UnityEngine.Vector3 UnityEngine.Vector3::rightVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___rightVector_10;
	// UnityEngine.Vector3 UnityEngine.Vector3::forwardVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___forwardVector_11;
	// UnityEngine.Vector3 UnityEngine.Vector3::backVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___backVector_12;
	// UnityEngine.Vector3 UnityEngine.Vector3::positiveInfinityVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___positiveInfinityVector_13;
	// UnityEngine.Vector3 UnityEngine.Vector3::negativeInfinityVector
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___negativeInfinityVector_14;
};

// UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData
struct PoseData_t67ECD1DA6257206C1935CCD030E1E1EF57E1443A 
{
	// System.Collections.Generic.List`1<System.String> UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData::PoseNames
	List_1_tF470A3BE5C1B5B68E1325EF3F109D172E60BD7CD* ___PoseNames_0;
	// System.Collections.Generic.List`1<UnityEngine.SpatialTracking.TrackedPoseDriver/TrackedPose> UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData::Poses
	List_1_t8A06DB5554CD76CE072807DE6EF4198109D84E53* ___Poses_1;
};
// Native definition for P/Invoke marshalling of UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData
struct PoseData_t67ECD1DA6257206C1935CCD030E1E1EF57E1443A_marshaled_pinvoke
{
	List_1_tF470A3BE5C1B5B68E1325EF3F109D172E60BD7CD* ___PoseNames_0;
	List_1_t8A06DB5554CD76CE072807DE6EF4198109D84E53* ___Poses_1;
};
// Native definition for COM marshalling of UnityEngine.SpatialTracking.TrackedPoseDriverDataDescription/PoseData
struct PoseData_t67ECD1DA6257206C1935CCD030E1E1EF57E1443A_marshaled_com
{
	List_1_tF470A3BE5C1B5B68E1325EF3F109D172E60BD7CD* ___PoseNames_0;
	List_1_t8A06DB5554CD76CE072807DE6EF4198109D84E53* ___Poses_1;
};

// UnityEngine.Object
struct Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C  : public RuntimeObject
{
	// System.IntPtr UnityEngine.Object::m_CachedPtr
	intptr_t ___m_CachedPtr_0;
};

struct Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C_StaticFields
{
	// System.Int32 UnityEngine.Object::OffsetOfInstanceIDInCPlusPlusObject
	int32_t ___OffsetOfInstanceIDInCPlusPlusObject_1;
};
// Native definition for P/Invoke marshalling of UnityEngine.Object
struct Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C_marshaled_pinvoke
{
	intptr_t ___m_CachedPtr_0;
};
// Native definition for COM marshalling of UnityEngine.Object
struct Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C_marshaled_com
{
	intptr_t ___m_CachedPtr_0;
};

// UnityEngine.Playables.PlayableHandle
struct PlayableHandle_t5D6A01EF94382EFEDC047202F71DF882769654D4 
{
	// System.IntPtr UnityEngine.Playables.PlayableHandle::m_Handle
	intptr_t ___m_Handle_0;
	// System.UInt32 UnityEngine.Playables.PlayableHandle::m_Version
	uint32_t ___m_Version_1;
};

struct PlayableHandle_t5D6A01EF94382EFEDC047202F71DF882769654D4_StaticFields
{
	// UnityEngine.Playables.PlayableHandle UnityEngine.Playables.PlayableHandle::m_Null
	PlayableHandle_t5D6A01EF94382EFEDC047202F71DF882769654D4 ___m_Null_2;
};

// UnityEngine.Playables.PlayableOutputHandle
struct PlayableOutputHandle_tEB217645A8C0356A3AC6F964F283003B9740E883 
{
	// System.IntPtr UnityEngine.Playables.PlayableOutputHandle::m_Handle
	intptr_t ___m_Handle_0;
	// System.UInt32 UnityEngine.Playables.PlayableOutputHandle::m_Version
	uint32_t ___m_Version_1;
};

struct PlayableOutputHandle_tEB217645A8C0356A3AC6F964F283003B9740E883_StaticFields
{
	// UnityEngine.Playables.PlayableOutputHandle UnityEngine.Playables.PlayableOutputHandle::m_Null
	PlayableOutputHandle_tEB217645A8C0356A3AC6F964F283003B9740E883 ___m_Null_2;
};

// UnityEngine.Pose
struct Pose_t06BA69EAA6E9FAF60056D519A87D25F54AFE7971 
{
	// UnityEngine.Vector3 UnityEngine.Pose::position
	Vector3_t24C512C7B96BBABAD472002D0BA2BDA40A5A80B2 ___position_0;
	// UnityEngine.Quaternion UnityEngine.Pose::rotation
	Quaternion_tDA59F214EF07D7700B26E40E562F267AF7306974 ___rotation_1;
};

struct Pose_t06BA69EAA6E9FAF60056D519A87D25F54AFE7971_StaticFields
{
	// UnityEngine.Pose UnityEngine.Pose::k_Identity
	Pose_t06BA69EAA6E9FAF60056D519A87D25F54AFE7971 ___k_Identity_2;
};

// UnityEngine.RemoteConfigSettings
struct RemoteConfigSettings_tC979947EE51355162B3241B9F80D95A8FD25FE52  : public RuntimeObject
{
	// System.IntPtr UnityEngine.RemoteConfigSettings::m_Ptr
	intptr_t ___m_Ptr_0;
	// System.Action`1<System.Boolean> UnityEngine.RemoteConfigSettings::Updated
	Action_1_t10DCB0C07D0D3C565CEACADC80D1152B35A45F6C* ___Updated_1;
};
// Native definition for P/Invoke marshalling of UnityEngine.RemoteConfigSettings
struct RemoteConfigSettings_tC979947EE51355162B3241B9F80D95A8FD25FE52_marshaled_pinvoke
{
	intptr_t ___m_Ptr_0;
	Il2CppMethodPointer ___Updated_1;
};
// Native definition for COM marshalling of UnityEngine.RemoteConfigSettings
struct RemoteConfigSettings_tC979947EE51355162B3241B9F80D95A8FD25FE52_marshaled_com
{
	intptr_t ___m_Ptr_0;
	Il2CppMethodPointer ___Updated_1;
};

// UnityEngine.Audio.AudioClipPlayable
struct AudioClipPlayable_tD4B758E68CAE03CB0CD31F90C8A3E603B97143A0 
{
	// UnityEngine.Playables.PlayableHandle UnityEngine.Audio.AudioClipPlayable::m_Handle
	PlayableHandle_t5D6A01EF94382EFEDC047202F71DF882769654D4 ___m_Handle_0;
};

// UnityEngine.Audio.AudioMixerPlayable
struct AudioMixerPlayable_t6AADDF0C53DF1B4C17969EC24B3B4E4975F3A56C 
{
	// UnityEngine.Playables.PlayableHandle UnityEngine.Audio.AudioMixerPlayable::m_Handle
	PlayableHandle_t5D6A01EF94382EFEDC047202F71DF882769654D4 ___m_Handle_0;
};

// UnityEngine.Audio.AudioPlayableOutput
struct AudioPlayableOutput_tC3DFF8095F429D90129A367EAB98A24F6D6ADF20 
{
	// UnityEngine.Playables.PlayableOutputHandle UnityEngine.Audio.AudioPlayableOutput::m_Handle
	PlayableOutputHandle_tEB217645A8C0356A3AC6F964F283003B9740E883 ___m_Handle_0;
};

// UnityEngine.Component
struct Component_t39FBE53E5EFCF4409111FB22C15FF73717632EC3  : public Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C
{
};

// UnityEngine.ScriptableObject
struct ScriptableObject_tB3BFDB921A1B1795B38A5417D3B97A89A140436A  : public Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C
{
};
// Native definition for P/Invoke marshalling of UnityEngine.ScriptableObject
struct ScriptableObject_tB3BFDB921A1B1795B38A5417D3B97A89A140436A_marshaled_pinvoke : public Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C_marshaled_pinvoke
{
};
// Native definition for COM marshalling of UnityEngine.ScriptableObject
struct ScriptableObject_tB3BFDB921A1B1795B38A5417D3B97A89A140436A_marshaled_com : public Object_tC12DECB6760A7F2CBF65D9DCF18D044C2D97152C_marshaled_com
{
};

// UnityEngine.Behaviour
struct Behaviour_t01970CFBBA658497AE30F311C447DB0440BAB7FA  : public Component_t39FBE53E5EFCF4409111FB22C15FF73717632EC3
{
};

// UnityEngine.XR.OpenXR.Features.OpenXRFeature
struct OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143  : public ScriptableObject_tB3BFDB921A1B1795B38A5417D3B97A89A140436A
{
	// System.Boolean UnityEngine.XR.OpenXR.Features.OpenXRFeature::m_enabled
	bool ___m_enabled_4;
	// System.Boolean UnityEngine.XR.OpenXR.Features.OpenXRFeature::<failedInitialization>k__BackingField
	bool ___U3CfailedInitializationU3Ek__BackingField_5;
	// System.String UnityEngine.XR.OpenXR.Features.OpenXRFeature::nameUi
	String_t* ___nameUi_7;
	// System.String UnityEngine.XR.OpenXR.Features.OpenXRFeature::version
	String_t* ___version_8;
	// System.String UnityEngine.XR.OpenXR.Features.OpenXRFeature::featureIdInternal
	String_t* ___featureIdInternal_9;
	// System.String UnityEngine.XR.OpenXR.Features.OpenXRFeature::openxrExtensionStrings
	String_t* ___openxrExtensionStrings_10;
	// System.String UnityEngine.XR.OpenXR.Features.OpenXRFeature::company
	String_t* ___company_11;
	// System.Int32 UnityEngine.XR.OpenXR.Features.OpenXRFeature::priority
	int32_t ___priority_12;
	// System.Boolean UnityEngine.XR.OpenXR.Features.OpenXRFeature::required
	bool ___required_13;
};

struct OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143_StaticFields
{
	// System.Boolean UnityEngine.XR.OpenXR.Features.OpenXRFeature::<requiredFeatureFailed>k__BackingField
	bool ___U3CrequiredFeatureFailedU3Ek__BackingField_6;
};

// UnityEngine.XR.OpenXR.Features.ConformanceAutomation.ConformanceAutomationFeature
struct ConformanceAutomationFeature_t0C2E5D391DBCC81F1B86F2D7E34719B7D292BFF7  : public OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143
{
};

struct ConformanceAutomationFeature_t0C2E5D391DBCC81F1B86F2D7E34719B7D292BFF7_StaticFields
{
	// System.UInt64 UnityEngine.XR.OpenXR.Features.ConformanceAutomation.ConformanceAutomationFeature::xrInstance
	uint64_t ___xrInstance_16;
	// System.UInt64 UnityEngine.XR.OpenXR.Features.ConformanceAutomation.ConformanceAutomationFeature::xrSession
	uint64_t ___xrSession_17;
};

// UnityEngine.XR.OpenXR.Features.Mock.MockRuntime
struct MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF  : public OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143
{
	// System.Boolean UnityEngine.XR.OpenXR.Features.Mock.MockRuntime::ignoreValidationErrors
	bool ___ignoreValidationErrors_19;
};

struct MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF_StaticFields
{
	// System.Collections.Generic.Dictionary`2<System.String,UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/AfterFunctionDelegate> UnityEngine.XR.OpenXR.Features.Mock.MockRuntime::s_AfterFunctionCallbacks
	Dictionary_2_t07B33916E5B9BFBEDDE5C206E597C4A2071ED5E6* ___s_AfterFunctionCallbacks_15;
	// System.Collections.Generic.Dictionary`2<System.String,UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/BeforeFunctionDelegate> UnityEngine.XR.OpenXR.Features.Mock.MockRuntime::s_BeforeFunctionCallbacks
	Dictionary_2_tE800B4C2237603A792FFCCFB9BFC21EA79CB7F3F* ___s_BeforeFunctionCallbacks_16;
	// UnityEngine.XR.OpenXR.Features.Mock.MockRuntime/ScriptEventDelegate UnityEngine.XR.OpenXR.Features.Mock.MockRuntime::onScriptEvent
	ScriptEventDelegate_t0DE50F0234F04B68173703087BFCB08BB4922E20* ___onScriptEvent_17;
};

// UnityEngine.MonoBehaviour
struct MonoBehaviour_t532A11E69716D348D8AA7F854AFCBFCB8AD17F71  : public Behaviour_t01970CFBBA658497AE30F311C447DB0440BAB7FA
{
};

// UnityEngine.XR.OpenXR.Features.OculusQuestSupport.OculusQuestFeature
struct OculusQuestFeature_tF5FA7128BB36F546D5CF7094A93B812DAC667810  : public OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143
{
};

// UnityEngine.XR.OpenXR.Features.RuntimeDebugger.RuntimeDebuggerOpenXRFeature
struct RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA  : public OpenXRFeature_tC2F8F480D62C277B2ECDD605F64E45053CD85143
{
	// System.UInt32 UnityEngine.XR.OpenXR.Features.RuntimeDebugger.RuntimeDebuggerOpenXRFeature::cacheSize
	uint32_t ___cacheSize_17;
	// System.UInt32 UnityEngine.XR.OpenXR.Features.RuntimeDebugger.RuntimeDebuggerOpenXRFeature::perThreadCacheSize
	uint32_t ___perThreadCacheSize_18;
};

struct RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA_StaticFields
{
	// System.Guid UnityEngine.XR.OpenXR.Features.RuntimeDebugger.RuntimeDebuggerOpenXRFeature::kEditorToPlayerRequestDebuggerOutput
	Guid_t ___kEditorToPlayerRequestDebuggerOutput_15;
	// System.Guid UnityEngine.XR.OpenXR.Features.RuntimeDebugger.RuntimeDebuggerOpenXRFeature::kPlayerToEditorSendDebuggerOutput
	Guid_t ___kPlayerToEditorSendDebuggerOutput_16;
};

// UnityEngine.SpatialTracking.TrackedPoseDriver
struct TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD  : public MonoBehaviour_t532A11E69716D348D8AA7F854AFCBFCB8AD17F71
{
	// UnityEngine.SpatialTracking.TrackedPoseDriver/DeviceType UnityEngine.SpatialTracking.TrackedPoseDriver::m_Device
	int32_t ___m_Device_4;
	// UnityEngine.SpatialTracking.TrackedPoseDriver/TrackedPose UnityEngine.SpatialTracking.TrackedPoseDriver::m_PoseSource
	int32_t ___m_PoseSource_5;
	// UnityEngine.Experimental.XR.Interaction.BasePoseProvider UnityEngine.SpatialTracking.TrackedPoseDriver::m_PoseProviderComponent
	BasePoseProvider_t55E2883DF2C8052200284D64B68471636876FA1D* ___m_PoseProviderComponent_6;
	// UnityEngine.SpatialTracking.TrackedPoseDriver/TrackingType UnityEngine.SpatialTracking.TrackedPoseDriver::m_TrackingType
	int32_t ___m_TrackingType_7;
	// UnityEngine.SpatialTracking.TrackedPoseDriver/UpdateType UnityEngine.SpatialTracking.TrackedPoseDriver::m_UpdateType
	int32_t ___m_UpdateType_8;
	// System.Boolean UnityEngine.SpatialTracking.TrackedPoseDriver::m_UseRelativeTransform
	bool ___m_UseRelativeTransform_9;
	// UnityEngine.Pose UnityEngine.SpatialTracking.TrackedPoseDriver::m_OriginPose
	Pose_t06BA69EAA6E9FAF60056D519A87D25F54AFE7971 ___m_OriginPose_10;
};
#ifdef __clang__
#pragma clang diagnostic pop
#endif



#ifdef __clang__
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Winvalid-offsetof"
#pragma clang diagnostic ignored "-Wunused-variable"
#endif
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6000[1] = 
{
	static_cast<int32_t>(offsetof(AudioClipPlayable_tD4B758E68CAE03CB0CD31F90C8A3E603B97143A0, ___m_Handle_0)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6001[1] = 
{
	static_cast<int32_t>(offsetof(AudioMixerPlayable_t6AADDF0C53DF1B4C17969EC24B3B4E4975F3A56C, ___m_Handle_0)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6002[1] = 
{
	static_cast<int32_t>(offsetof(AudioPlayableOutput_tC3DFF8095F429D90129A367EAB98A24F6D6ADF20, ___m_Handle_0)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6004[2] = 
{
	static_cast<int32_t>(offsetof(AudioSampleProvider_t602353124A2F6F2AEC38E56C3C21932344F712E2, ___sampleFramesAvailable_0)),static_cast<int32_t>(offsetof(AudioSampleProvider_t602353124A2F6F2AEC38E56C3C21932344F712E2, ___sampleFramesOverflow_1)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6007[3] = 
{
	static_cast<int32_t>(offsetof(RemoteSettings_t9DFFC747AB3E7A39DF4527F245B529A407427250_StaticFields, ___Updated_0)),static_cast<int32_t>(offsetof(RemoteSettings_t9DFFC747AB3E7A39DF4527F245B529A407427250_StaticFields, ___BeforeFetchFromServer_1)),static_cast<int32_t>(offsetof(RemoteSettings_t9DFFC747AB3E7A39DF4527F245B529A407427250_StaticFields, ___Completed_2)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6008[2] = 
{
	static_cast<int32_t>(offsetof(RemoteConfigSettings_tC979947EE51355162B3241B9F80D95A8FD25FE52, ___m_Ptr_0)),static_cast<int32_t>(offsetof(RemoteConfigSettings_tC979947EE51355162B3241B9F80D95A8FD25FE52, ___Updated_1)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6009[12] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,0,0,0,0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6012[5] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6015[2] = 
{
	static_cast<int32_t>(offsetof(AnalyticsSessionInfo_tDE8F7A9E13EF9723E2D975F76E916753DA61AD76_StaticFields, ___sessionStateChanged_0)),static_cast<int32_t>(offsetof(AnalyticsSessionInfo_tDE8F7A9E13EF9723E2D975F76E916753DA61AD76_StaticFields, ___identityTokenChanged_1)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6017[9] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6020[6] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6021[4] = 
{
	static_cast<int32_t>(offsetof(NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD, ___eventBuffer_0)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD, ___eventCount_1)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD, ___sizeInBytes_2)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEventBuffer_t4EE5873AD7998E0E83C9F8585C338AB14C9101FD, ___capacityInBytes_3)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6022[6] = 
{
	0,static_cast<int32_t>(offsetof(NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8, ___type_1)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8, ___sizeInBytes_2)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8, ___deviceId_3)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8, ___time_4)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(NativeInputEvent_tDE7DE9A48ACA442A8D37E2920836D00C26408CB8, ___eventId_5)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6023[6] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6024[4] = 
{
	static_cast<int32_t>(offsetof(NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE_StaticFields, ___onUpdate_0)),static_cast<int32_t>(offsetof(NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE_StaticFields, ___onBeforeUpdate_1)),static_cast<int32_t>(offsetof(NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE_StaticFields, ___onShouldRunUpdate_2)),static_cast<int32_t>(offsetof(NativeInputSystem_tCFE5554EBC0D3EE1DAD80FC55CE0DE38A3DDC5EE_StaticFields, ___s_OnDeviceDiscoveredCallback_3)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6028[2] = 
{
	static_cast<int32_t>(offsetof(PoseData_t67ECD1DA6257206C1935CCD030E1E1EF57E1443A, ___PoseNames_0)) + static_cast<int32_t>(sizeof(RuntimeObject)),static_cast<int32_t>(offsetof(PoseData_t67ECD1DA6257206C1935CCD030E1E1EF57E1443A, ___Poses_1)) + static_cast<int32_t>(sizeof(RuntimeObject)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6029[1] = 
{
	static_cast<int32_t>(offsetof(TrackedPoseDriverDataDescription_tDD80D37EB4F938007BCE0FAB9705032594E4D9FF_StaticFields, ___DeviceData_0)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6030[4] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6031[1] = 
{
	static_cast<int32_t>(offsetof(PoseDataSource_tF08072CF4DBA9641E6AE6D1DBA1D421DA9C46858_StaticFields, ___nodeStates_0)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6032[4] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6033[12] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,0,0,0,0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6034[4] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6035[4] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6036[7] = 
{
	static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_Device_4)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_PoseSource_5)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_PoseProviderComponent_6)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_TrackingType_7)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_UpdateType_8)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_UseRelativeTransform_9)),static_cast<int32_t>(offsetof(TrackedPoseDriver_t5A2DEE7957ED76932DB7460383BF09AB1CB4CCCD, ___m_OriginPose_10)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6042[1] = 
{
	static_cast<int32_t>(offsetof(XRDevice_tD076A68EFE413B3EEEEA362BE0364A488B58F194_StaticFields, ___deviceLoaded_0)),};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6050[5] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6054[6] = 
{
	static_cast<int32_t>(offsetof(MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF_StaticFields, ___s_AfterFunctionCallbacks_15)),static_cast<int32_t>(offsetof(MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF_StaticFields, ___s_BeforeFunctionCallbacks_16)),static_cast<int32_t>(offsetof(MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF_StaticFields, ___onScriptEvent_17)),0,static_cast<int32_t>(offsetof(MockRuntime_tC5F1019CA2D3E89010E3A3BFC89834251257B2AF, ___ignoreValidationErrors_19)),0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6056[4] = 
{
	0,static_cast<int32_t>(offsetof(ConformanceAutomationFeature_t0C2E5D391DBCC81F1B86F2D7E34719B7D292BFF7_StaticFields, ___xrInstance_16)),static_cast<int32_t>(offsetof(ConformanceAutomationFeature_t0C2E5D391DBCC81F1B86F2D7E34719B7D292BFF7_StaticFields, ___xrSession_17)),0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6060[4] = 
{
	static_cast<int32_t>(sizeof(RuntimeObject)),0,0,0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6068[5] = 
{
	static_cast<int32_t>(offsetof(RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA_StaticFields, ___kEditorToPlayerRequestDebuggerOutput_15)),static_cast<int32_t>(offsetof(RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA_StaticFields, ___kPlayerToEditorSendDebuggerOutput_16)),static_cast<int32_t>(offsetof(RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA, ___cacheSize_17)),static_cast<int32_t>(offsetof(RuntimeDebuggerOpenXRFeature_t1E3C60D2636DEC25D95E63BB3300DBFC5E9057BA, ___perThreadCacheSize_18)),0,};
IL2CPP_EXTERN_C const int32_t g_FieldOffsetTable6070[1] = 
{
	0,};
